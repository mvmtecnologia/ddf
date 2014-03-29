package br.com.dicadefarmacia.infra.utils;


/**
 * @author Marcus Soliva - viniciussoliva
 * @author Matheus Cardoso - mtzimba
 * @author Rodolfo Martins - furstmartins
 */
public class MensagensUtils {
	public static final String FORM = "form";
	public static final String INSERT_OK = "Registro gravado com sucesso!";
	public static final String UPDATE_OK = "Atualizado com sucesso!";
	public static final String UPDATE_DELETADO = "Não foi possivel alterar esse registro provavelmente o registro foi excluido!";
	public static final String DELETE_OK = "Deletado com Sucesso!";
	public static final String DELETE_ERRO = "Não possivel excluir esse registro, ele é referenciado por outros registros!";
	public static final String DELETE_DELETADO = "Esse registro já foi excluido!";
	
	
	 
//	/**
//	 * @author rozolin
//	 * @Descrição Mensagem de erro
//	 * @param mensagem - Mensagem que será mostrada apra o usúario 
//	 * @param idForm - Corresponde ao id do formulario da tela caso for passado null recebera o valor padrão ("form") 
//	 */
//	public static void mensagemErro(String mensagem,String idForm){
//		addMensagem(mensagem, idForm, FacesMessage.SEVERITY_ERROR);
//	}
//	
//	/**
//	 * @author rozolin
//	 * @Descrição Mensagem de Informaão
//	 * @param mensagem - Mensagem que será mostrada apra o usúario 
//	 * @param idForm - Corresponde ao id do formulario da tela caso for passado null recebera o valor padr�o ("form") 
//	 */
//	public static void mensagemInfo(String mensagem, String idForm){
//		addMensagem(mensagem, idForm, FacesMessage.SEVERITY_INFO);
//	}
//	
//	/**
//	 * @author rozolin
//	 * @Descrição Mensagem de Fatal 
//	 * @param mensagem - Mensagem que ser� mostrada apra o usúario 
//	 * @param idForm - Corresponde ao id do formulario da tela caso for passado null recebera o valor padrão ("form") 
//	 */
//	public static void mensagemFatal(String mensagem, String idForm){
//		addMensagem(mensagem, idForm, FacesMessage.SEVERITY_FATAL);
//	}
//	
//	/**
//	 * @author rozolin
//	 * @Descrição Mensagem de Aviso
//	 * @param mensagem - Mensagem que será mostrada apra o us�ario 
//	 * @param idForm - Corresponde ao id do formulario da tela caso for passado null recebera o valor padrão ("form") 
//	 */
//	public static void mensagemWarn(String mensagem, String idForm){
//		addMensagem(mensagem, idForm, FacesMessage.SEVERITY_WARN);
//	}
//	
//	private static void addMensagem(String mensagem, String idForm, Severity severity){
//		idForm = retornaIdForm(idForm);
//		FacesContext.getCurrentInstance().addMessage(idForm, new FacesMessage(severity,mensagem,null));			
//	}
//	
//	
//	
//	private static String retornaIdForm(String idForm) {
//		if(idForm == null || idForm == ""){
//			return FORM;
//		}
//		return idForm;
//	}
}
