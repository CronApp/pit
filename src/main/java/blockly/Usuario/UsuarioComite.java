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
 * @since 25/08/2023, 17:41:56
 *
 */
public static Var RetornaUsarioPertenceComite() throws Exception {
 return new Callable<Var>() {

   private Var usuarioPertenceComite = Var.VAR_NULL;

   public Var call() throws Exception {
    usuarioPertenceComite =
    cronapi.database.Operations.query(Var.valueOf("app"),Var.valueOf("SELECT us.NAME,\n       COUNT(us.NAME)\nFROM USER us\nLEFT JOIN USER_SECURABLE usec ON (us.id = usec.user_id)\nLEFT JOIN SECURABLE sec ON (sec.id = usec.securable_id)\nLEFT JOIN USER_ROLE ur ON (ur.user_id = us.id)\nWHERE ((normalized_email = :userName\n        OR normalized_user_name = :userName)\n       AND ((SEC.NAME = \'Administrators\'\n             OR SEC.NAME = \'Comite\'))\n       OR ((normalized_email = :userName\n            OR normalized_user_name = :userName)\n           AND ROLE_ID =\n             (SELECT ID\n              FROM ROLE\n              WHERE NORMALIZED_NAME = \'administrators\')))\nGROUP BY us.NAME"),Var.valueOf("userName",
    cronapi.util.Operations.getCurrentUserName()));
    return
cronapi.logic.Operations.isNullOrEmpty(usuarioPertenceComite)
.negate();
   }
 }.call();
}

}

