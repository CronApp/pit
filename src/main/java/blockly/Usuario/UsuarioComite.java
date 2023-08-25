package blockly.Usuario;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class UsuarioComite {

public static final int TIMEOUT = 300;

/**
 *
 * @author Silvio De Oliveira Carlos
 * @since 25/08/2023, 12:00:40
 *
 */
public static Var RetornaUsarioPertenceComite() throws Exception {
 return new Callable<Var>() {

   private Var usuarioPertenceComite = Var.VAR_NULL;

   public Var call() throws Exception {
    usuarioPertenceComite =
    cronapi.database.Operations.query(Var.valueOf("app"),Var.valueOf("SELECT \n	SEC.NAME, COUNT(SEC.NAME)\nFROM \n	SECURABLE sec \nLEFT JOIN USER_SECURABLE usec ON (sec.id = usec.securable_id) \nLEFT JOIN USER us ON (us.id = usec.user_id)\nWHERE (normalized_email = :userName OR normalized_user_name = :userName)\nAND (SEC.NAME = \'Administrators\' OR SEC.NAME = \'Comite\')\nGROUP BY SEC.NAME"),Var.valueOf("userName",
    cronapi.util.Operations.getCurrentUserName()));
    return
cronapi.logic.Operations.isNullOrEmpty(usuarioPertenceComite)
.negate();
   }
 }.call();
}

}

