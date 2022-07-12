package br.com.alura.mvc.mundi.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptadorDeAcessos extends HandlerInterceptorAdapter {
	
	public static List<Acesso> acessos = new ArrayList<Acesso>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Acesso acesso = new Acesso();
		acesso.path = request.getRequestURI();
		acesso.data = LocalDateTime.now();
		
		request.setAttribute("acesso", acesso);
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		Acesso acesso = (Acesso) request.getAttribute("acesso");
		acesso.durucao = Duration.between(acesso.data, LocalDateTime.now());
		acessos.add(acesso);
	}
	
	public static class Acesso {
		private String path;
		private LocalDateTime data;
		private Duration durucao;
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public LocalDateTime getData() {
			return data;
		}
		public void setData(LocalDateTime data) {
			this.data = data;
		}
		public Duration getDurucao() {
			return durucao;
		}
		public void setDurucao(Duration durucao) {
			this.durucao = durucao;
		}
		
		
	}
}
