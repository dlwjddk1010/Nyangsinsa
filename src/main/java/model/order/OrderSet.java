package model.order;

import java.util.ArrayList;

import model.orderDetail.OrderDetailVO;

public class OrderSet {

	private OrderVO ovo;
	private ArrayList<OrderDetailVO> odatas;

	public OrderVO getOvo() {
		return ovo;
	}

	public void setOvo(OrderVO ovo) {
		this.ovo = ovo;
	}

	public ArrayList<OrderDetailVO> getOdatas() {
		return odatas;
	}

	public void setOdatas(ArrayList<OrderDetailVO> odatas) {
		this.odatas = odatas;
	}

}
