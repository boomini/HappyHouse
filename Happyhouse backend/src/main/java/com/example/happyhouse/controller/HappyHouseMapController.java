package com.example.happyhouse.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.happyhouse.model.BicycleDto;
import com.example.happyhouse.model.BusDto;
import com.example.happyhouse.model.HomeInfoDto;
import com.example.happyhouse.model.HouseInfoDto;
import com.example.happyhouse.model.SidoGugunCodeDto;
import com.example.happyhouse.model.SubwayDto;
import com.example.happyhouse.model.WordDto;
import com.example.happyhouse.model.service.HappyHouseMapService;
import com.example.util.NewsApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/map")
@Api("아파트지도컨트롤러  API V1")
public class HappyHouseMapController {
	
	@Autowired
	private HappyHouseMapService happyHouseMapService;
	
	@ApiOperation(value = "시도 목록", notes = "시도 목록 를 반환한다.", response = List.class)
	@GetMapping("/sido")
	public ResponseEntity<List<SidoGugunCodeDto>> sido() throws Exception{
		return new ResponseEntity<List<SidoGugunCodeDto>>(happyHouseMapService.getSido(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "구군 목록", notes = "해당 시코드의 구군 목록 를 반환한다.", response = List.class)
	@GetMapping("/gugun")
	public ResponseEntity<List<SidoGugunCodeDto>> gugun(@RequestParam("sido") String sido) throws Exception{
		return new ResponseEntity<List<SidoGugunCodeDto>>(happyHouseMapService.getGugunInSido(sido), HttpStatus.OK);
	}
	
	@ApiOperation(value = "동 목록", notes = "해당 구군코드의 동목록 를 반환한다.", response = List.class)
	@GetMapping("/dong")
	public ResponseEntity<List<HouseInfoDto>> dong(@RequestParam("gugun") String gugun) throws Exception{
		return new ResponseEntity<List<HouseInfoDto>>(happyHouseMapService.getDongInGugun(gugun), HttpStatus.OK);
	}
	
	@ApiOperation(value = "아파트 목록", notes = "해당 동코드의 아파트 목록 를 반환한다.", response = List.class)
	@GetMapping("/apt")
	public ResponseEntity<List<HouseInfoDto>> apt(@RequestParam("dong") String dong,@RequestParam("year") String year,@RequestParam("month") String month) throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		map.put("dong",dong);
		map.put("year",year);
		map.put("month",month);
		System.out.println(happyHouseMapService.getAptInDong(map));
		return new ResponseEntity<List<HouseInfoDto>>(happyHouseMapService.getAptInDong(map), HttpStatus.OK);
	}
	@ApiOperation(value = "집목록", notes = "해당 동코드의 집목록을 반환한다..", response = List.class)
	@GetMapping("/home")
	public ResponseEntity<List<HomeInfoDto>> home(@RequestParam("dong") String dong) throws Exception{
		return new ResponseEntity<List<HomeInfoDto>>(happyHouseMapService.getHomeInDong(dong), HttpStatus.OK);
	}
	@ApiOperation(value = "뉴스 정보를 얻는다.", response = String.class)
	@RequestMapping(value = "/news/{keyword}", method = RequestMethod.GET)
	public ResponseEntity<String> news(@PathVariable("keyword") @ApiParam(value = "검색할 뉴스정보 keyword.", required = true) String keyword) throws Exception {
		String clientId = "wrkZjByj56cMsCnOdbb_"; //애플리케이션 클라이언트 아이디값"
        String clientSecret = "JcsPfrSLmy"; //애플리케이션 클라이언트 시크릿값"

        String text = null;
        try {
            text = URLEncoder.encode(keyword, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }

        String apiURL = "https://openapi.naver.com/v1/search/news.json?query=" + text+ "&display=5&start=1&sort=sim";    // json 결과
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = NewsApi.get(apiURL,requestHeaders);

		return new ResponseEntity<String>(responseBody, HttpStatus.OK);
	}
	@ApiOperation(value = "버스목록", notes = "해당 동코드의 집목록을 반환한다..", response = List.class)
	@GetMapping("/bus")
	public ResponseEntity<List<BusDto>> bus(@RequestParam("lat") String lat,@RequestParam("lng") String lng) throws Exception{
		Map<String, String> map = new HashMap<>();
		map.put("lat",lat);
		map.put("lng",lng);
		return new ResponseEntity<List<BusDto>>(happyHouseMapService.getBus(map), HttpStatus.OK);
	}
	@ApiOperation(value = "지하철목록", notes = "해당 동코드의 집목록을 반환한다..", response = List.class)
	@GetMapping("/subway")
	public ResponseEntity<List<SubwayDto>> subway(@RequestParam("lat") String lat,@RequestParam("lng") String lng) throws Exception{
		Map<String, String> map = new HashMap<>();
		map.put("lat",lat);
		map.put("lng",lng);
		return new ResponseEntity<List<SubwayDto>>(happyHouseMapService.getSubway(map), HttpStatus.OK);
	}
	@ApiOperation(value = "자전거보관소목록", notes = "해당 동코드의 집목록을 반환한다..", response = List.class)
	@GetMapping("/bicycle")
	public ResponseEntity<List<BicycleDto>> bicycle(@RequestParam("lat") String lat,@RequestParam("lng") String lng) throws Exception{
		Map<String, String> map = new HashMap<>();
		map.put("lat",lat);
		map.put("lng",lng);
		return new ResponseEntity<List<BicycleDto>>(happyHouseMapService.getBicycle(map), HttpStatus.OK);
	}
	
	@ApiOperation(value = "교통수", notes = "해당 교통편의기능 수를 제공..", response = List.class)
	@GetMapping("/transcnt")
	public ResponseEntity<Map<String, String>> gettranscnt(@RequestParam("lat") String lat,@RequestParam("lng") String lng) throws Exception{
		Map<String, String> map = new HashMap<>();
		map.put("lat",lat);
		map.put("lng",lng);
		return new ResponseEntity<Map<String, String>>(happyHouseMapService.gettranscnt(map), HttpStatus.OK);
	}
	
	
//	@ApiOperation(value = "아파트 거래목록", notes = "해당 아파트의 거래정보를 반환한다.", response = List.class)
//	@GetMapping("/deal")
//	public ResponseEntity<List<HouseDealDto>> deal(@RequestParam("apt") String apt) throws Exception{
//		System.out.println(apt);
//		return new ResponseEntity<List<HouseDealDto>>(happyHouseMapService.getHouseDeal(apt), HttpStatus.OK);
//	}
	
	
}
