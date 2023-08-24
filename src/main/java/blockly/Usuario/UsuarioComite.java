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
 * @since 24/08/2023, 08:55:06
 *
 */
public static Var RetornaUsarioPertenceComite() throws Exception {
 return new Callable<Var>() {

   private Var usuarioPertenceComite = Var.VAR_NULL;

   public Var call() throws Exception {
    usuarioPertenceComite =
    cronapi.database.Operations.query(Var.valueOf("app"),Var.valueOf("SELECT \n	SEC.NAME, COUNT(SEC.NAME)\nFROM \n	SECURABLE sec \nLEFT JOIN USER_SECURABLE usec ON (sec.id = usec.securable_id) \nLEFT JOIN USER us ON (us.id = usec.user_id)\nWHERE normalized_user_name = :userName\nAND (SEC.NAME = \'Administrators\' OR SEC.NAME = \'Comite\')\nGROUP BY SEC.NAME"),Var.valueOf("userName",
    cronapi.util.Operations.getCurrentUserName()));
    System.out.println(
    cronapi.logic.Operations.isNullOrEmpty(usuarioPertenceComite)
    .negate().getObjectAsString());
    return
cronapi.logic.Operations.isNullOrEmpty(usuarioPertenceComite)
.negate();
   }
 }.call();
}

}

