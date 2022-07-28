
public class Filmoteca {
	private Filme primeiroTitulo;
	private Filme ultimoTitulo;
	private Filme primeiroAP;
	private Filme ultimoAP;
	private Filme primeiroEstilo;
	private Filme ultimoEstilo;

	

	public Filmoteca() {
		this.primeiroTitulo = null;
		this.ultimoTitulo = null;
	}

	public boolean estaVazia() {
		return (this.primeiroTitulo == null && this.primeiroAP == null && this.primeiroEstilo == null);
	}

	private void insereOrdenadoPorTitulo(Filme filme) {
		Filme aux, ant;

		if (filme.getTitulo().compareTo(this.primeiroTitulo.getTitulo()) < 0) {
			filme.setProxTitulo(this.primeiroTitulo);
			this.primeiroTitulo.setAntTitulo(filme);
			this.primeiroTitulo = filme;
			return;
		}

		ant = this.primeiroTitulo;
		for (aux = this.primeiroTitulo.getProxTitulo(); aux != null
				&& filme.getTitulo().compareTo(aux.getTitulo()) > 0; aux = aux.getProxTitulo()) {
			ant = aux;
		}

		ant.setProxTitulo(filme);
		filme.setAntTitulo(ant);
		filme.setProxTitulo(aux);

		if (filme.getProxTitulo() == null) {
			this.ultimoTitulo = filme;

		} else {
			aux.setAntTitulo(filme);
		}
	}

	private void insereOrdenadoPorAtorPrincipal(Filme filme) {
		Filme aux, ant;

		if (filme.getAtorPrincipal().compareTo(this.primeiroAP.getAtorPrincipal()) < 0) {
			filme.setProxAP(this.primeiroAP);
			this.primeiroAP.setAntAP(filme);
			this.primeiroAP = filme;
			return;
		}

		ant = this.primeiroAP;
		for (aux = this.primeiroAP.getProxAP(); aux != null
				&& filme.getAtorPrincipal().compareTo(aux.getAtorPrincipal()) > 0; aux = aux.getProxAP()) {
			ant = aux;
		}

		ant.setProxAP(filme);
		filme.setAntAP(ant);
		filme.setProxAP(aux);

		if (filme.getProxAP() == null) {
			this.ultimoAP = filme;

		} else {
			aux.setAntAP(filme);
		}
	}

	private void insereOrdenadoPorEstilo(Filme filme) {
		Filme aux, ant;

		if (filme.getEstilo().compareTo(this.primeiroEstilo.getEstilo()) < 0) {
			filme.setProxEstilo(this.primeiroEstilo);
			this.primeiroEstilo.setAntEstilo(filme);
			this.primeiroEstilo = filme;
			return;
		}

		ant = this.primeiroEstilo;
		for (aux = this.primeiroEstilo.getProxEstilo(); aux != null
				&& filme.getEstilo().compareTo(aux.getEstilo()) > 0; aux = aux.getProxEstilo()) {
			ant = aux;
		}

		ant.setProxEstilo(filme);
		filme.setAntEstilo(ant);
		filme.setProxEstilo(aux);
	
		if (filme.getProxEstilo() == null) {
			this.ultimoEstilo = filme;

		} else {
			aux.setAntEstilo(filme);
		}

	}

	public void insereOrdenado(String titulo, String sinopse, String produtora, String atorPrincipal, String estilo
			) {
		Filme filme = new Filme(titulo, sinopse, produtora, atorPrincipal, estilo);

		if (this.estaVazia()) {
			this.primeiroTitulo = this.ultimoTitulo = filme;
			this.primeiroAP = this.ultimoAP = filme;
			this.primeiroEstilo = this.ultimoEstilo = filme;
			return;
		}

		this.insereOrdenadoPorTitulo(filme);
		this.insereOrdenadoPorAtorPrincipal(filme);
		this.insereOrdenadoPorEstilo(filme);
	}
	
	private boolean excluiFilmeDaListaPorAtorPrincipal(Filme filme) {
		Filme filmeAnterior = null;
		String ator = filme.getAtorPrincipal();

		for (filme = this.primeiroAP; filme != null && !filme.getAtorPrincipal().equals(ator); filme = filme.getProxAP()) {
			filmeAnterior = filme;
		}
		
		if (filme == null) {
			return false;
		} else {
			if (filmeAnterior == null) {
				this.primeiroAP = filme.getProxAP();
				
				if(this.primeiroAP == null) {
					this.ultimoAP = this.primeiroAP;
				}else {
					this.primeiroAP.setAntAP(null);

				}
				return true;
			}
			
			filmeAnterior.setProxAP(filme.getProxAP());
			
			if(filme.getProxAP() == null) {
				this.ultimoAP = filmeAnterior;
			}else {
				filme.getProxAP().setAntAP(filmeAnterior);
			}
			
			return true;
		}

	}
	
	private boolean excluiFilmeDaListaPorEstilo(Filme filme) {
		Filme filmeAnterior = null;
		String estilo = filme.getEstilo();

		for (filme = this.primeiroEstilo; filme != null && !filme.getEstilo().equals(estilo); filme = filme.getProxEstilo()) {
			filmeAnterior = filme;
		}
		if (filme == null) {
			return false;
		} else {
			if (filmeAnterior == null) {
				this.primeiroEstilo = filme.getProxEstilo();
				
				if(this.primeiroEstilo == null) {
					this.ultimoEstilo = this.primeiroEstilo;
				}else {
					this.primeiroEstilo.setAntEstilo(null);

				}
				return true;
			}
			
			filmeAnterior.setProxEstilo(filme.getProxEstilo());
			
			if(filme.getProxEstilo() == null) {
				this.ultimoEstilo = filmeAnterior;
			}else {
				filme.getProxEstilo().setAntEstilo(filmeAnterior);
			}
			
			return true;
		}

	}
	
	
	private boolean excluiFilmeDaListaPorTitulo(Filme filme) {
		Filme filmeAnterior = null;
		String titulo = filme.getTitulo();

		for (filme = this.primeiroTitulo; filme != null && !filme.getTitulo().equals(titulo); filme = filme.getProxTitulo()) {
			filmeAnterior = filme;
		}
		if (filme == null) {
			return false;
		}
		
			if (filmeAnterior == null) {
				this.primeiroTitulo = filme.getProxTitulo();
				
				if(this.primeiroTitulo == null) {
					this.ultimoTitulo = this.primeiroTitulo;
				}else {
					this.primeiroTitulo.setAntTitulo(null);
				}
				return true;
			}
			
			filmeAnterior.setProxTitulo(filme.getProxTitulo());
			
			if(filme.getProxTitulo() == null) {
				this.ultimoTitulo = filmeAnterior;
			}else {
				filme.getProxTitulo().setAntTitulo(filmeAnterior);
			}
			
			return true;
		
	}
	
	public boolean excluiFilme(String titulo) {
		Filme filme;
		
		for(filme = this.primeiroAP; filme != null && filme.getTitulo().compareTo(titulo) != 0; filme = filme.getProxAP());

		if(this.estaVazia()) {
			return false;
		}
		if(this.excluiFilmeDaListaPorAtorPrincipal(filme)) {
			return this.excluiFilmeDaListaPorEstilo(filme) &&
			this.excluiFilmeDaListaPorTitulo(filme);
		}else {
			return false;
		}
				
	
		/*if(this.excluiFilmeDaListaPorAtorPrincipal(filme, anteriorFilme)) {
			return excluiFilmeDaListaPorEstilo(filme) && excluiFilmeDaListaPorTitulo(filme);
		}else {
			return false;
		}
*/
	}
	
	public Filme retornaPrimeiro() {
		
		if(this.estaVazia() == false) {
			return this.primeiroAP;
		}
		
		return null;
	}

	public void imprimeOrdenadoPorTitulo() {
		for (Filme f = this.primeiroTitulo; f != null; f = f.getProxTitulo()) {
			f.imprimeFilme();
		}
	}

	public void imprimeOrdenadoPorAtorPrincipal() {
		for (Filme f = this.primeiroAP; f != null; f = f.getProxAP()) {
			f.imprimeFilme();
		}
	}

	public void imprimeOrdenadoPorEstilo() {
		for (Filme f = this.primeiroEstilo; f != null; f = f.getProxEstilo()) {
			f.imprimeFilme();
		}
	}

}
