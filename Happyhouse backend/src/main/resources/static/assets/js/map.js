var root="/happyhouse";

// 마커를 담을 배열입니다
var markers = [];

var mapContainer = document.getElementById("map"), // 지도를 표시할 div
  mapOption = {
    center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
    level: 3, // 지도의 확대 레벨
  };

// 지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption);

// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places();

// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({ zIndex: 1 });
// 커스텀 오버레이를 생성합니다
var customOverlay;
//주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 검색 결과 목록과 마커를 표출하는 함수입니다
function displayPlaces(places) {
	
  var listEl = document.getElementById("placesList"),
    menuEl = document.getElementById("menu_wrap"),
    fragment = document.createDocumentFragment(),
    bounds = new kakao.maps.LatLngBounds(),
    listStr = "";
  
	//검색 결과 목록에 추가된 항목들을 제거합니다
	removeAllChildNods(listEl);
	 console.log(places);
	// 지도에 표시되고 있는 마커를 제거합니다
	removeMarker();
	var deallist=[];
	for(var i=0; i<places.length; i++){
		console.log(places);
		var placePosition = new kakao.maps.LatLng(places[i].lat, places[i].lng),
		marker = addMarker(placePosition, i),
		itemEl = getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다
		
		 // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
		  // LatLngBounds 객체에 좌표를 추가합니다
		  bounds.extend(placePosition);
		  console.log(places[i]);
		// 마커와 검색결과 항목에 mouseover 했을때
		  // 해당 장소에 인포윈도우에 장소명을 표시합니다
		  // mouseout 했을 때는 인포윈도우를 닫습니다
		  (function (marker, title, code, place) {
		    kakao.maps.event.addListener(marker, "mouseover", function () {
		      displayInfowindow(marker, title, place);
		      console.log(title+" " + code);
		    });
		    
		    kakao.maps.event.addListener(marker, "click", function () {
		    	$.get(root+"/map/deal"
						,{apt:code}
						,function(aptdeal, status){
							console.log(aptdeal);
							//기존 매물 내역 삭제
                            $('#info-append').empty();
							for (var k = 0; k < aptdeal.length; k++) {
								
								$('#info-append').append(
                               		 `<div class="info-box overflow-auto border border bg-dark p-2 mt-4">
                                       <h5 class="text-white font-weight-light mt-1 mb-2 text-center border-bottom p-1">매 물</h5>
                                           <div class="info-element mt-2 text-center border border-white badge-light" style="color:white">
                                           	매매가   |  ${aptdeal[k].dealAmount}   만원
                                           </div>
                                           <div class="info-element mt-2 text-center border border-white badge-light" style="color:white">
                                           	전용면적   |  ${aptdeal[k].area}   m^2
                                           </div>
                                           <div class="info-element mt-2 text-center border border-white badge-light" style="color:white">
                                           	층수   |     ${aptdeal[k].floor}   층
                                           </div>
                                       </div>`
                               );
	                                

//	                                document.getElementById('info0').innerHTML = "아파트명   |   " + aptdeal[k].name;
//	                                document.getElementById('info0').style.display = "";
//	                                document.getElementById('info1').innerHTML = "도로명   |   " + aptdeal[k].road;
//	                                document.getElementById('info1').style.display = "";
//	                                document.getElementById('info2').innerHTML = "건축년도   |   " + aptdeal[k].year + " 년";
//	                                document.getElementById('info2').style.display = "";

	                        }
						}//function
						, "json"
				);//get
			    });
		    
		    kakao.maps.event.addListener(marker, "mouseout", function () {
		    	console.log(customOverlay);
		    	customOverlay.setMap(null);
		     	
		      
		    });

		     itemEl.onmouseover = function () {
		       displayInfowindow(marker, title);
		     };

		    itemEl.onmouseout = function () {
		         customOverlay.setMap(null);
		     };
		  })(marker, places[i].aptName, places[i].aptCode, places[i]);

		  fragment.appendChild(itemEl);
	}
  // 마커를 생성하고 지도에 표시합니다 

  // 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
  listEl.appendChild(fragment);
  menuEl.scrollTop = 0;

  // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
  map.setBounds(bounds);
}

// 검색결과 항목을 Element로 반환하는 함수입니다
function getListItem(index, place) {
  var el = document.createElement("li"),
    itemStr =
      '<span class="markerbg marker_' +
      (index + 1) +
      '"></span>' +
      '<div class="info">' +
      "   <h5>" +
      place.aptName +
      "</h5> <button>관심등록</button>";

    itemStr += "    <span>" +place.sidoName +" "+place.gugunName +" "+place.dongName+" "+place.jibun +"</span>";

  el.innerHTML = itemStr;
  el.className = "item";

  return el;
}

function searchDetailAddrFromCoords(lat, lng, callback) {
    // 좌표로 법정동 상세 주소 정보를 요청합니다
    geocoder.coord2Address(lng, lat, callback);
}

// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, idx, title) {
  var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png", // 마커 이미지 url, 스프라이트 이미지를 씁니다
    imageSize = new kakao.maps.Size(36, 37), // 마커 이미지의 크기
    imgOptions = {
      spriteSize: new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
      spriteOrigin: new kakao.maps.Point(0, idx * 46 + 10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
      offset: new kakao.maps.Point(13, 37), // 마커 좌표에 일치시킬 이미지 내에서의 좌표
    },
    markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
    marker = new kakao.maps.Marker({
      position: position, // 마커의 위치
      image: markerImage,
    });

  marker.setMap(map); // 지도 위에 마커를 표출합니다
  markers.push(marker); // 배열에 생성된 마커를 추가합니다

  return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
  for (var i = 0; i < markers.length; i++) {
    markers[i].setMap(null);
  }
  markers = [];
}

// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
function displayPagination(pagination) {
  var paginationEl = document.getElementById("pagination"),
    fragment = document.createDocumentFragment(),
    i;

  // 기존에 추가된 페이지번호를 삭제합니다
  while (paginationEl.hasChildNodes()) {
    paginationEl.removeChild(paginationEl.lastChild);
  }

  for (i = 1; i <= pagination.last; i++) {
    var el = document.createElement("a");
    el.href = "#";
    el.innerHTML = i;

    if (i === pagination.current) {
      el.className = "on";
    } else {
      el.onclick = (function (i) {
        return function () {
          pagination.gotoPage(i);
        };
      })(i);
    }

    fragment.appendChild(el);
  }
  paginationEl.appendChild(fragment);
}

// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
// 인포윈도우에 장소명을 표시합니다
function displayInfowindow(marker, title, place) {
  console.log(title);
  var content =
    '<div class="overlaybox">' +
    '    <div class="boxtitle">' +
    title +
    "</div>" +
    '    <div class="first">' +
    '<img src="assets/apt.png" style="width:247px; height:136px;" alt="">' +
    "    </div>" +
    "    <ul>" +
    '        <li class="up">' +
    '            <span class="title">건축년도</span>' +
    '            <span class="count">'+place.buildYear+'</span>' +
    "        </li>" +
    "        <li>" +
    '            <span class="title">주소</span>' +
    '            <span class="count">'+place.sidoName +" "+place.gugunName +" "+place.dongName+" "+place.jibun+'</span>' +
    "        </li>" +
    "        <li>" +
    '            <span class="title">최신거래금액</span>' +
    '            <span class="count">'+place.recentPrice+'</span>' +
    "        </li>" +
    "        <li>" +
    '            <span class="last" id="recenthistor" data-toggle="modal" data-target="#myModal">아파트정보 update</span>' +
    "        </li>" +
    "    </ul>" +
    "</div>";
  var position = new kakao.maps.LatLng(marker.getPosition().getLat()+0.00033, marker.getPosition().getLng()-0.00003);
  customOverlay = new kakao.maps.CustomOverlay({
    position: position,
    content: content,
    xAnchor: 0.3,
    yAnchor: 0.91,
  });
  customOverlay.setMap(map);

  $(document).on("click", "#recenthistor", function () {
    console.log("check");
    window.open("./history.html", "history", "width=500, height=500, top=0, left=0");
  });
}

// 검색결과 목록의 자식 Element를 제거하는 함수입니다
function removeAllChildNods(el) {
  while (el.hasChildNodes()) {
    el.removeChild(el.lastChild);
  }
}

//category 목록
//마커를 클릭했을 때 해당 장소의 상세정보를 보여줄 커스텀오버레이입니다
var placeOverlay = new kakao.maps.CustomOverlay({zIndex:1}), 
    contentNode = document.createElement('div'), // 커스텀 오버레이의 컨텐츠 엘리먼트 입니다 
    markers2 = [], // 마커를 담을 배열입니다
    currCategory = ''; // 현재 선택된 카테고리를 가지고 있을 변수입니다

//장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places(map); 

// 지도에 idle 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'idle', searchPlaces);

// 커스텀 오버레이의 컨텐츠 노드에 css class를 추가합니다 
contentNode.className = 'placeinfo_wrap';

// 커스텀 오버레이의 컨텐츠 노드에 mousedown, touchstart 이벤트가 발생했을때
// 지도 객체에 이벤트가 전달되지 않도록 이벤트 핸들러로 kakao.maps.event.preventMap 메소드를 등록합니다 
addEventHandle(contentNode, 'mousedown', kakao.maps.event.preventMap);
addEventHandle(contentNode, 'touchstart', kakao.maps.event.preventMap);

// 커스텀 오버레이 컨텐츠를 설정합니다
placeOverlay.setContent(contentNode);  

// 각 카테고리에 클릭 이벤트를 등록합니다
addCategoryClickEvent();

// 엘리먼트에 이벤트 핸들러를 등록하는 함수입니다
function addEventHandle(target, type, callback) {
    if (target.addEventListener) {
        target.addEventListener(type, callback);
    } else {
        target.attachEvent('on' + type, callback);
    }
}

// 카테고리 검색을 요청하는 함수입니다
function searchPlaces() {
    if (!currCategory) {
        return;
    }
    
    // 커스텀 오버레이를 숨깁니다 
    placeOverlay.setMap(null);

    // 지도에 표시되고 있는 마커를 제거합니다
    removeMarker2();
    
    ps.categorySearch(currCategory, placesSearchCB, {useMapBounds:true}); 
}

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 정상적으로 검색이 완료됐으면 지도에 마커를 표출합니다
        displayPlaces2(data);
    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
        // 검색결과가 없는경우 해야할 처리가 있다면 이곳에 작성해 주세요

    } else if (status === kakao.maps.services.Status.ERROR) {
        // 에러로 인해 검색결과가 나오지 않은 경우 해야할 처리가 있다면 이곳에 작성해 주세요
        
    }
}

// 지도에 마커를 표출하는 함수입니다
function displayPlaces2(places) {

    // 몇번째 카테고리가 선택되어 있는지 얻어옵니다
    // 이 순서는 스프라이트 이미지에서의 위치를 계산하는데 사용됩니다
    var order = document.getElementById(currCategory).getAttribute('data-order');

    

    for ( var i=0; i<places.length; i++ ) {

            // 마커를 생성하고 지도에 표시합니다
            var marker = addMarker2(new kakao.maps.LatLng(places[i].y, places[i].x), order);

            // 마커와 검색결과 항목을 클릭 했을 때
            // 장소정보를 표출하도록 클릭 이벤트를 등록합니다
            (function(marker, place) {
                kakao.maps.event.addListener(marker, 'click', function() {
                    displayPlaceInfo2(place);
                });
            })(marker, places[i]);
    }
}

// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker2(position, order) {
    var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(27, 28),  // 마커 이미지의 크기
        imgOptions =  {
            spriteSize : new kakao.maps.Size(72, 208), // 스프라이트 이미지의 크기
            spriteOrigin : new kakao.maps.Point(46, (order*36)), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset: new kakao.maps.Point(11, 28) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
            marker = new kakao.maps.Marker({
            position: position, // 마커의 위치
            image: markerImage 
        });

    marker.setMap(map); // 지도 위에 마커를 표출합니다
    markers2.push(marker);  // 배열에 생성된 마커를 추가합니다

    return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker2() {
    for ( var i = 0; i < markers2.length; i++ ) {
        markers2[i].setMap(null);
    }   
    markers2 = [];
}

// 클릭한 마커에 대한 장소 상세정보를 커스텀 오버레이로 표시하는 함수입니다
function displayPlaceInfo2 (place) {
    var content = '<div class="placeinfo">' +
                    '   <a class="title" href="' + place.place_url + '" target="_blank" title="' + place.place_name + '">' + place.place_name + '</a>';   

    if (place.road_address_name) {
        content += '    <span title="' + place.road_address_name + '">' + place.road_address_name + '</span>' +
                    '  <span class="jibun" title="' + place.address_name + '">(지번 : ' + place.address_name + ')</span>';
    }  else {
        content += '    <span title="' + place.address_name + '">' + place.address_name + '</span>';
    }                
   
    content += '    <span class="tel">' + place.phone + '</span>' + 
                '</div>' + 
                '<div class="after"></div>';

    contentNode.innerHTML = content;
    placeOverlay.setPosition(new kakao.maps.LatLng(place.y, place.x));
    placeOverlay.setMap(map);  
}


// 각 카테고리에 클릭 이벤트를 등록합니다
function addCategoryClickEvent() {
    var category = document.getElementById('category'),
        children = category.children;

    for (var i=0; i<children.length; i++) {
        children[i].onclick = onClickCategory;
    }
}

// 카테고리를 클릭했을 때 호출되는 함수입니다
function onClickCategory() {
    var id = this.id,
        className = this.className;

    placeOverlay.setMap(null);

    if (className === 'on') {
        currCategory = '';
        changeCategoryClass();
        removeMarker();
    } else {
        currCategory = id;
        changeCategoryClass(this);
        searchPlaces();
    }
}

// 클릭된 카테고리에만 클릭된 스타일을 적용하는 함수입니다
function changeCategoryClass(el) {
    var category = document.getElementById('category'),
        children = category.children,
        i;

    for ( i=0; i<children.length; i++ ) {
        children[i].className = '';
    }

    if (el) {
        el.className = 'on';
    } 
} 
 