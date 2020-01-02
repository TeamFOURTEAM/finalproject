package com.project.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.service.BasketService;
import com.project.service.PayService;
import com.project.vo.BasketVO;
import com.project.vo.PayVO;

@Controller
public class PayController {
	
	@Autowired
	private BasketService basketService;
	
	@Autowired
	private PayService payService;
	
	/** 결제페이지로 이동 **/
	@RequestMapping("shop/pay")
	public String pay() {
		
		return "redirect:/shop/pay_page";
	}//pay()
	
	
	/** 결제 페이지의 상품 목록 **/
	@RequestMapping("shop/pay_page")
	public String pay_list(
			HttpServletRequest request,
			HttpServletResponse response,
			Model basketList) throws Exception  {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		//session 처리!
		String user_id = "pebble";
		
		if(user_id == null) {
			out.println("<script>");
			out.println("alert('로그인 하신 후 이용해주세요.');");
			out.println("location='admin_login';");
			out.println("</script>");
			
		}else {
			Map<String,Object> map=new HashMap<String, Object>();
			List<BasketVO> list=this.basketService.listBasket(user_id);//결제 페이지의 상품 정보
			//만약 유저정보도 뽑아올거면 여기서 메서드 돌리기 -> 회원아이디로 회원정보에서 이름 전번 이메일
			
			int sumMoney=this.basketService.sumMoney(user_id);//결제 페이지의 상품 전체 금액 호출
			/* 장바구니 전체 금액에 따라 배송비 구분 */
			//배송료(10만원 이상 -> 무료, 미만 -> 2500원)
			int fee = sumMoney >= 100000 ? 0 : 2500;
			
			map.put("list",list); //장바구니 정보
			map.put("count",list.size());//장바구니 상품 유무
			map.put("sumMoney",sumMoney);//장바구니 합계 금액
			map.put("fee",fee);//배송비
			map.put("allSum",sumMoney+fee);//주문 총 합계 금액(상품 + 배송비)
			
			basketList.addAttribute("map",map);
			
			return "shop/pay_page";

		}//if else 
		
		return null;
	}
	
	/** 결제완료 페이지 **/
	@RequestMapping("shop/pay_page_confirm")
	public String pay_page_confirm() {
		
		return "shop/pay_page_confirm";
	}//pay_page_confirm()
	
	/** 결제하기(주문 목록 추가) **/
	@RequestMapping("shop/pay_page_ok")
	public String pay_page_ok(
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		//session 처리!
		String user_id = "pebble";
		
		if(user_id == null) {
			out.println("<script>");
			out.println("alert('로그인 하신 후 이용해주세요.');");
			out.println("location='admin_login';");
			out.println("</script>");
			
		}else {
			int pay_price=Integer.parseInt(request.getParameter("pay_price"));
			//총 결제 금액
			PayVO pay = new PayVO();
			pay.setUser_id(user_id); pay.setPay_price(pay_price);
			//유저 아이디와 결제 금액 저장
			
			this.payService.insertPay(pay,user_id);//주문 내역 추가,장바구니 업데이트
			//트랜잭션 적용
			
			return "redirect:/shop/pay_page_confirm";
		}//if else 

		return null;
	}
	
	/** 구매 내역으로 이동 **/
	@RequestMapping("shop/pay_list_go")
	public String pay_list_go() {
		
		return "redirect:/shop/pay_list";
	}//pay_list_go()
	
	/** 구매 내역 **/
	@RequestMapping("shop/pay_list")
	public String pay_list(
			PayVO pay,
			HttpServletResponse response,
			Model payList) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		//session 처리!
		String user_id = "pebble";
		
		if(user_id == null) {
			out.println("<script>");
			out.println("alert('로그인 하신 후 이용해주세요.');");
			out.println("location='admin_login';");
			out.println("</script>");
			
		}else {
			List<PayVO> list = this.payService.list_pay(user_id);//주문 내역 목록
			
			payList.addAttribute("list",list);
			
			return "shop/pay_list";
		}//if else
		
		return null;
	}//pay_list()
	
	/** 주문 상품명 클릭시, 해당 주문의 상품 리스트로 이동 **/
	@RequestMapping("shop/pay_item_list_go")
	public String pay_item_list_go(
			HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		
		int pay_no = Integer.parseInt(request.getParameter("pay_no"));
		int validity = Integer.parseInt(request.getParameter("validity"));
		
		redirectAttributes.addAttribute("pay_no",pay_no);
		redirectAttributes.addAttribute("validity",validity);
		
		return "redirect:/shop/pay_item_list";
	}//pay_item_list_go()
	
	@RequestMapping("shop/pay_item_list")
	public String pay_item_list(
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int pay_no = Integer.parseInt(request.getParameter("pay_no"));
		int validity = Integer.parseInt(request.getParameter("validity"));
		//선택한 주문 번호
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		//session 처리!
		String user_id = "pebble";
		
		if(user_id == null) {
			out.println("<script>");
			out.println("alert('로그인 하신 후 이용해주세요.');");
			out.println("location='admin_login';");
			out.println("</script>");
			
		}else {
			
			
			return "shop/pay_item_list";
		}//if else
		
		return "null";
	}//pay_item_list()
}

















