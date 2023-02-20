package controller;

//이동할 path, 타입(redirect/forward) 을 담고 있는 객체
public class ActionForward {
	private String path;
	private boolean redirect;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
}
