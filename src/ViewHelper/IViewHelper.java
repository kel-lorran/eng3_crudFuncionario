package ViewHelper;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dominio.EntidadeDominio;
import util.Result;

public interface IViewHelper {
	EntidadeDominio getEntidade(HttpServletRequest request);
	void setView (Result resultado, HttpServletRequest request, HttpServletResponse response) throws IOException;

}
