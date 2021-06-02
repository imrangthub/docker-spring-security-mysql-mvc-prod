package com.imranmadbar.objMapping;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.imranmadbar.util.CommonFunctions;
import com.imranmadbar.util.Def;

@Repository
@Transactional
public class ObjectMappingRepository implements CommonFunctions{
	
	
	
	public String reqReqPropMap(String orderId) {
		System.out.println("reqReqPropMap:"+orderId);
		return "reqReqPropMap:"+orderId;
	}

	
	public String reqBodyPropMap(String reqStr) {
		JSONObject json = new JSONObject(reqStr);
		String orderId = Def.getString(json, "orderId");
		System.out.println("reqBodyPropMap:"+orderId);
		
		
//		JSONObject json = new JSONObject(reqStr);
//		Long itemNo = Def.getLong(json, "itemNo");
//		Long labNo = Def.getLong(json, "labNo");
//		Long stampNo = Def.getLong(json, "stampNo");
//		String pStepProc = Def.getString(json, "pStepProc");
//		
//		if (labNo == null || itemNo == null || pStepProc == null) {
//			return getErrorResponse("Required data not found!");
//		}

//        String fromDateStr = request.getParameter("fromDate");
//        String toDateStr = request.getParameter("toDate");
//
//        Date fromDate = deateParse(fromDateStr, "dd/MM/yyyy");
//        Date toDate = deateParse(toDateStr, "dd/MM/yyyy");
//        
//        LOGGER.info("fromDate " + fromDate + " toDate " + toDate);
//    	if (fromDate != null && toDate != null) {
//			isSearch = true;
//	        viewPathSampleCollectionCollectedEntity.setFromDate(fromDate);
//	        viewPathSampleCollectionCollectedEntity.setToDate(toDate);
//			int setInvoiceFrmDateRs = setKParamPdSetInvoiceDateFrom(
//					viewPathSampleCollectionCollectedEntity.getFromDate());
//			int setInvoiceToDateRs = setKParamPdSetInvoiceDateTo(viewPathSampleCollectionCollectedEntity.getToDate());
//    	}

    	
    	
		
		return "reqBodyPropMap: "+orderId;
	}

	public String reqBodyEntityMap(String reqStr) {
		if (reqStr == null) {
			return "No data found !";
		}
		OrderDto orderDtoObj = new OrderDto();
		orderDtoObj = objectMapperReadValue(reqStr, OrderDto.class);
		System.out.println("reqBodyEntityMap:"+orderDtoObj);
		return "reqBodyEntityMapSuccess: "+orderDtoObj;
	}
	
	public String reqBodyEntityArrMap(String reqStr) {
		if (reqStr == null) {
			return "No data found !";
		}
		List<OrderDto> orderList = null;
		if (reqStr != null && !reqStr.equals("[]")) {
			orderList = objectMapperReadArrayValue(reqStr,
					OrderDto.class);
		}
		System.out.println("reqBodyEntityArrMapSuccess:"+orderList);
		return "reqBodyEntityArrMapSucces: "+orderList;
	}
	

}
