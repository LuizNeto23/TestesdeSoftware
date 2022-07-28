

public class Filme {
	/*Título: nome do filme;
	Sinopse: resumo do filme;
	Produtora: nome da produtora principal do filme;
	Ator Principal: nome do ator principal preferencialmente ou uma string com os atores principais;
	Estilo: estilo principal do filme (exemplo: ação, comédia, suspense, etc.).*/
	
	private String titulo;
	private String sinopse;
	private String produtora;
	private String atorPrincipal;
	private String estilo;
	private Filme antTitulo;
	private Filme proxTitulo;
	private Filme antAP;
	private Filme proxAP;
	private Filme antEstilo;
	private Filme proxEstilo;
	
	
	public Filme() {
		this.antTitulo = null;
		this.proxTitulo = null;
	}

	

	



	public Filme(String titulo, String sinopse, String produtora, String atorPrincipal, String estilo) {
		super();
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.produtora = produtora;
		this.atorPrincipal = atorPrincipal;
		this.estilo = estilo;
		this.antTitulo = null;
		this.proxTitulo = null;
		this.antAP = null;
		this.proxAP = null;
		this.antEstilo = null;
		this.proxEstilo = null;
	}


	
	public void imprimeFilme() {
		System.out.println("Título: " + titulo);
		System.out.println("Sinopse: " + sinopse);
		System.out.println("Produtora: " + produtora);
		System.out.println("Ator Principal: " + atorPrincipal);
		System.out.println("Estilo: " + estilo);
		System.out.println("-----------------------------------------------------");
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getSinopse() {
		return sinopse;
	}


	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}


	public String getProdutora() {
		return produtora;
	}


	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}


	public String getAtorPrincipal() {
		return atorPrincipal;
	}


	public void setAtorPrincipal(String atorPrincipal) {
		this.atorPrincipal = atorPrincipal;
	}


	public String getEstilo() {
		return estilo;
	}


	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}


	public Filme getAntTitulo() {
		return antTitulo;
	}


	public void setAntTitulo(Filme antTitulo) {
		this.antTitulo = antTitulo;
	}


	public Filme getProxTitulo() {
		return proxTitulo;
	}


	public void setProxTitulo(Filme proxTitulo) {
		this.proxTitulo = proxTitulo;
	}


	public Filme getAntAP() {
		return antAP;
	}


	public void setAntAP(Filme antAP) {
		this.antAP = antAP;
	}


	public Filme getProxAP() {
		return proxAP;
	}


	public void setProxAP(Filme proxAP) {
		this.proxAP = proxAP;
	}


	public Filme getAntEstilo() {
		return antEstilo;
	}


	public void setAntEstilo(Filme antEstilo) {
		this.antEstilo = antEstilo;
	}


	public Filme getProxEstilo() {
		return proxEstilo;
	}


	public void setProxEstilo(Filme proxEstilo) {
		this.proxEstilo = proxEstilo;
	}

	


	

	
	
	
}
