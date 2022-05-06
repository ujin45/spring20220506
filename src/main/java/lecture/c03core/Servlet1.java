package lecture.c03core;

public class Servlet1 {

	private Dao1 dao;  // dependency 
	
	public void doGet() {
		// request parameter 수집 / 가공
		
		// business logic 처리
		dao.select();
		// result setting
		
		// forward /redirect
	}
}
