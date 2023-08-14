package blockly.Votacao;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Votos {

public static final int TIMEOUT = 300;

/**
 *
 * @param idProjetoVotado
 *
 * @author Wesley Miranda De Oliveira
 * @since 14/08/2023, 09:56:10
 *
 */
public static Var ObtemVoto(@ParamMetaData(description = "idProjetoVotado", id = "2a202a21") Var idProjetoVotado) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    System.out.println(idProjetoVotado.getObjectAsString());
    return Var.VAR_NULL;
   }
 }.call();
}

}

