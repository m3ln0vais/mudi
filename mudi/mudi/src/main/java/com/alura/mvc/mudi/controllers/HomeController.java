package com.alura.mvc.mudi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alura.mvc.mudi.model.Pedido;
import com.alura.mvc.mudi.model.StatusPedidos;
import com.alura.mvc.mudi.repositories.PedidoRepository;	

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public String home(Model model) {
		
		List<Pedido> p = pedidoRepository.findAll();
		model.addAttribute("pedidos", p);
		return "home";
	}
	
	@GetMapping("/{status}")
	public String status(@PathVariable("status") String status, Model model) {
		
		List<Pedido> p = pedidoRepository.findByStatus(StatusPedidos.valueOf(status.toUpperCase()));
		model.addAttribute("pedidos", p);
		model.addAttribute("status", status);
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
