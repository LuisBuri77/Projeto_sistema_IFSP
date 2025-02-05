package com.projeto.service.paginacao;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PaginacaoConfig {

	public static Pageable gerarPagina (String pageNumber, 
			String pageSize, 
			String props, 
			String dir) {
		
		return PageRequest.of(Integer.valueOf(pageNumber),
				Integer.valueOf(pageSize),
				getSortDirection(props,dir));
		
	}
	
	private static Sort getSortDirection (String props, String dir) {
		
		Sort sort = dir.equalsIgnoreCase(Sort.Direction.ASC.name())
				? Sort.by(props).ascending()
				: Sort.by(props).descending();
						
				return sort ;
		
	}
}
