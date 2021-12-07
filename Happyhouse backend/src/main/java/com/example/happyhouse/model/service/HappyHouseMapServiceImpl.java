package com.example.happyhouse.model.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.example.happyhouse.model.BicycleDto;
import com.example.happyhouse.model.BusDto;
import com.example.happyhouse.model.HomeDealDto;
import com.example.happyhouse.model.HomeInfoDto;
import com.example.happyhouse.model.HomeRentDto;
import com.example.happyhouse.model.HouseDealDto;
import com.example.happyhouse.model.HouseInfoDto;
import com.example.happyhouse.model.SidoGugunCodeDto;
import com.example.happyhouse.model.SubwayDto;
import com.example.happyhouse.model.mapper.HouseMapMapper;


@Service
public class HappyHouseMapServiceImpl implements HappyHouseMapService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		return sqlSession.getMapper(HouseMapMapper.class).getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		return sqlSession.getMapper(HouseMapMapper.class).getGugunInSido(sido);
	}

//	@Override
//	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
//		return sqlSession.getMapper(HouseMapMapper.class).getDongInGugun(gugun);
//	}

//	@Override
//	public List<HouseInfoDto> getAptInDong(String dong) throws Exception {
//		return sqlSession.getMapper(HouseMapMapper.class).getAptInDong(dong);
//	}
	
	@Override
	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
		return sqlSession.getMapper(HouseMapMapper.class).getDongInGugun(gugun);
	}
	
	public List<HouseInfoDto> getAptInDong(Map<String, String> map) throws Exception {
		List<HouseInfoDto> infolist = new ArrayList<HouseInfoDto>();
	       List<String> check = new ArrayList<String>();
	      String pageNo = "1";
	      String numOfRows = "1000";
	      String serviceKey = "5QaPpa8kkge2Dl4XoYO54r8EPZ8Kg%2BPGsJtjuF36TSTQZf3eryNQP6f4sElP%2BcPANncLbM6FkGAubmuXrhGkDA%3D%3D";
	      String dongCode = map.get("dong");
	      if (dongCode.length() > 5) {         
	         dongCode = dongCode.substring(5);
	      }
	      String gugunCode = map.get("dong").substring(0,5);
	      BufferedReader in = null;

	      try {
	    	  for(int mon=1; mon<=10; mon++) {
		    	  
		      
		      String DEAL_YMD = String.valueOf(202100+mon);
		      
		      //System.out.println(">>>>>>>>>>>>>>>>>>>>> gugunCode: " + gugunCode + " dongCode: " + dongCode + "");
		      
		      String url = "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?";
		      url += "pageNo=" + pageNo + "&";
		       url += "numOfRows=" + numOfRows + "&";       
		       url += "LAWD_CD=" + gugunCode + "&";       
		       url += "DEAL_YMD=" + DEAL_YMD + "&";
		       url += "serviceKey=" + serviceKey;
		       
		      URL urlObj = null;
		      URLConnection connection = null;
		      
	         urlObj = new URL(url);
	         connection = urlObj.openConnection();
	         connection.setRequestProperty("CONTENT-TYPE", "text/html");
	         in = new BufferedReader(new InputStreamReader(urlObj.openStream(), "utf-8"));

	         // XML 문서 파싱
	         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder documentBuilder = factory.newDocumentBuilder();

	         InputSource is = new InputSource(in);
	         documentBuilder = factory.newDocumentBuilder();
	         Document document = documentBuilder.parse(is);

	         NodeList items = document.getDocumentElement().getElementsByTagName("item");
	        // System.out.println(items);
	         //System.out.println(items.getLength());
	         for (int i = 0; i < items.getLength(); i++) {
	            NodeList item = items.item(i).getChildNodes();
	            HouseInfoDto houseInfoDto = new HouseInfoDto();
	            HouseDealDto houseDealDto = new HouseDealDto();
	            //System.out.println(">>>>>>>>iiiiiii" +i+ item);
	            for (int j = 0; j < item.getLength(); j++) {
	            	//System.out.println(">>>>>jjjjjjjjjj"+item.item(j));
	               String nodeName = item.item(j).getNodeName().trim();
	               String nodeValue = item.item(j).getTextContent().trim();
	               
	              // System.out.println(">>>>>>>>jjjjjjjjj" +j+ nodeName + " " + nodeValue);
	               if ("일련번호".equals(nodeName)) {
	                  String[] no = nodeValue.split("-");
	                  houseInfoDto.setAptCode(no[1]);
	                  houseDealDto.setAptCode(Integer.parseInt(no[1]));
	               } else if ("법정동읍면동코드".equals(nodeName)) {
	                  if (dongCode.length() == 5 && !nodeValue.equals(dongCode)) { // 현재 찾는 동이 아니면
		                     houseInfoDto = null;
		                     break;
		                  }
		                //  System.out.println(dong + " / " + item.item(j).getNodeName() + " " + item.item(j).getTextContent());
		                  houseInfoDto.setDongCode(dongCode);
			       } else if ("아파트".equals(nodeName)) {
	            	   //System.out.println(">>>>>>>>>>>>>>>>>아파트");
	            	   
	                  houseInfoDto.setAptName(nodeValue);
	               } else if ("법정동".equals(nodeName)) {
	                  houseInfoDto.setDongName(nodeValue);
	               } else if ("건축년도".equals(nodeName)) {
	                  houseInfoDto.setBuildYear(Integer.parseInt(nodeValue));
	               } else if ("도로명".equals(nodeName)) {
	                  houseInfoDto.setRoadName(nodeValue);
	               } else if ("도로명건물본번호코드".equals(nodeName)) {
	                  houseInfoDto.setBuildingMajorCode(nodeValue);
	               } else if ("도로명건물부번호코드".equals(nodeName)) {
	                  houseInfoDto.setBuildingMinorCode(nodeValue);
	               } else if ("지번".equals(nodeName)) {
	                  houseInfoDto.setJibun(nodeValue);
	               } else if ("거래금액".equals(nodeName)) {
	                  houseDealDto.setDealAmount(nodeValue);
	               } else if ("년".equals(nodeName)) {
	                  houseDealDto.setDealYear(Integer.parseInt(nodeValue));
	               } else if ("전용면적".equals(nodeName)) {
	                  houseDealDto.setArea(nodeValue);
	               } else if ("층".equals(nodeName)) {
	                  houseDealDto.setFloor(nodeValue);
	               } else if ("월".equals(nodeName)) {
		              houseDealDto.setDealMonth(Integer.parseInt(nodeValue));
		           } else if ("일".equals(nodeName)) {
	                  houseDealDto.setDealDay(Integer.parseInt(nodeValue));
	               }
	               
	            }
	            if(houseInfoDto!=null) {
	            	int index = 0;
	            	int dealidx = 0;
	            	System.out.println(check.toString());
	            	System.out.println(index);
		               if(!check.contains(houseInfoDto.getAptCode())) {
		            	   infolist.add(houseInfoDto);
		            	   index = infolist.size()-1;
		            	   check.add(houseInfoDto.getAptCode());
		               }else {
		            	   index=check.indexOf(houseInfoDto.getAptCode());  
		            	   dealidx = infolist.get(index).getHousedeal().size();
		               }
		               houseDealDto.setDealno(dealidx);
		               infolist.get(index).addHousedeal(houseDealDto);
	            }
	            
	         }
	    	  }
	      } finally {
	         if (in != null) {
	            in.close();
	         }
	      }
	      getRecentPrice(infolist);
	      return infolist;
	   }

	private void getRecentPrice(List<HouseInfoDto> infolist) {
		for(int i=0; i<infolist.size(); i++) {
			int sum = 0;
			List<HouseDealDto> dealList = infolist.get(i).getHousedeal(); 
			int n = dealList.size();
			for(int j=0; j<n; j++) {
				int num = Integer.valueOf(dealList.get(j).getDealAmount().replace(",",""));
				sum+=num;
			}
			infolist.get(i).setAvgPrice(String.valueOf(sum/n));
			infolist.get(i).setRecentPrice(dealList.get(n-1).getDealAmount());
		}
		
	}
	private void getPrice(List<HomeInfoDto> infolist) {
		for(int i=0; i<infolist.size(); i++) {
			int sum = 0;
			List<HomeDealDto> dealList = infolist.get(i).getHousedeal(); 
			int n = dealList.size();
			if(n!=0) {
				for(int j=0; j<n; j++) {
					int num = Integer.valueOf(dealList.get(j).getDealAmount().replace(",",""));
					sum+=num;
				}
				infolist.get(i).setAvgPrice(String.valueOf(sum/n));
				infolist.get(i).setRecentPrice(dealList.get(n-1).getDealAmount());
			}
			
		}
		
	}

	@Override
	public List<HomeInfoDto> getHomeInDong(String dong) throws Exception {
		List<HomeInfoDto> infolist = new ArrayList<HomeInfoDto>();
		infolist = sqlSession.getMapper(HouseMapMapper.class).getHomeInDong(dong);
		for(int i=0; i<infolist.size(); i++) {
			List<HomeDealDto> deallist = new ArrayList<HomeDealDto>();
			List<HomeRentDto> rentlist= new ArrayList<HomeRentDto>();
			
			if(infolist.get(i).getType().equals("H")) {
				System.out.println("H : "+infolist.get(i).toString());
				deallist = sqlSession.getMapper(HouseMapMapper.class).getHouseDealInHome(infolist.get(i));
				rentlist = sqlSession.getMapper(HouseMapMapper.class).getHouseRentInHome(infolist.get(i));
			}
			else if(infolist.get(i).getType().equals("A")) {
				System.out.println("A : "+infolist.get(i).toString());
				deallist = sqlSession.getMapper(HouseMapMapper.class).getAptDealInHome(infolist.get(i));
				rentlist = sqlSession.getMapper(HouseMapMapper.class).getAptRentInHome(infolist.get(i));
			}
			else if(infolist.get(i).getType().equals("O")) {
				System.out.println("O : "+infolist.get(i).toString());
				deallist = sqlSession.getMapper(HouseMapMapper.class).getOfficeDealInHome(infolist.get(i));
				rentlist = sqlSession.getMapper(HouseMapMapper.class).getOfficeRentInHome(infolist.get(i));
			}
			infolist.get(i).setHousedeal(deallist);
			infolist.get(i).setHouserent(rentlist);
			
			if(deallist.size()!=0) {
				infolist.get(i).setBuildYear(deallist.get(0).getBuildYear());
			}else {
				infolist.get(i).setBuildYear(rentlist.get(0).getBuildYear());
			}
			
			
		}
		getPrice(infolist);
		return infolist;
	}

	@Override
	public List<BusDto> getBus(Map<String, String> map) throws Exception {
		return sqlSession.getMapper(HouseMapMapper.class).getBus(map);
	}

	@Override
	public List<SubwayDto> getSubway(Map<String, String> map) throws Exception {
		return sqlSession.getMapper(HouseMapMapper.class).getSubway(map);
	}

	@Override
	public List<BicycleDto> getBicycle(Map<String, String> map) throws Exception {
		return sqlSession.getMapper(HouseMapMapper.class).getBicycle(map);
	}

	@Override
	public Map<String, String> gettranscnt(Map<String, String> map) throws Exception {
		Map<String,String> returnmap = new HashMap<String,String>();
		returnmap.put("bus", sqlSession.getMapper(HouseMapMapper.class).getbuscnt(map));
		returnmap.put("subway", sqlSession.getMapper(HouseMapMapper.class).getsubcnt(map));
		returnmap.put("bicycle", sqlSession.getMapper(HouseMapMapper.class).getbiccnt(map));
		return returnmap;
	}

//	@Override
//	public List<HouseDealDto> getHouseDeal(String apt) throws Exception {
//		return sqlSession.getMapper(HouseMapMapper.class).getHouseDeal(apt);
//	}
}
