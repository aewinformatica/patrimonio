package br.com.aewinformatica.patrimonio.cors;

//@Configuration
//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter  {

//	@Autowired
//	private ApiProperty apiProperty;

//	@Override
//	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
//			throws IOException, ServletException {
//		
//		HttpServletRequest request = (HttpServletRequest) req;
//		HttpServletResponse response = (HttpServletResponse) resp;
//		
//		response.setHeader("Access-Control-Allow-Origin", apiProperty.getOriginPermitida());
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//		
//		if ("OPTIONS".equals(request.getMethod()) && apiProperty.getOriginPermitida().equals(request.getHeader("Origin"))) {
//			response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
//        	response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
//        	response.setHeader("Access-Control-Max-Age", "3600");
//			
//			response.setStatus(HttpServletResponse.SC_OK);
//		} else {
//			chain.doFilter(req, resp);
//		}
//		
//	}

}
