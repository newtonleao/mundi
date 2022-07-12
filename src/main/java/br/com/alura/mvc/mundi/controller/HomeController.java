package br.com.alura.mvc.mundi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mundi.model.Pedido;
import br.com.alura.mvc.mundi.model.StatusPedido;
import br.com.alura.mvc.mundi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@GetMapping
	public String home(Model model, Principal principal) {
//		List<Pedido> pedidos = pedidoRepository.recuperaTodosOsPedidos();
//		List<Pedido> pedidos = pedidoRepository.findAllByUsuario(principal.getName());
		Sort sort = Sort.by("dataEntrega").descending();
		PageRequest paginacao = PageRequest.of(0, 10,sort);
		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE,paginacao);
		model.addAttribute("pedidos", pedidos);
		return "home";
	}

}
