package com.alura.mvc.mudi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alura.mvc.mudi.dto.PedidoDTO;
import com.alura.mvc.mudi.model.Pedido;
import com.alura.mvc.mudi.repositories.PedidoRepository;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("/pedidoForm")
	public String form(PedidoDTO pedidoDTO) {
		return "pedido/pedidoForm";
	}
	
	@PostMapping("/novo")
	public String novo(@Valid PedidoDTO pedidoDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "pedido/pedidoForm";
		}
		Pedido p = pedidoDTO.toPedido();
		pedidoRepository.save(p);
		return "redirect:/home";
	}
}
