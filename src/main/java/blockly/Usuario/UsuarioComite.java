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
 * @since 23/08/2023, 16:33:50
 *
 */
public static Var RetornaUsarioPertenceComite() throws Exception {
 return new Callable<Var>() {

   private Var usuarioPertenceComite = Var.VAR_NULL;

   public Var call() throws Exception {
    System.out.println(
    Var.valueOf("Oiiiii").getObjectAsString());
    usuarioPertenceComite =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Securable"),Var.valueOf("select \n	s.name, \n	u.user.normalizedUserName \nfrom \n	Securable s \njoin\n	UserSecurable u on (s.id = u.securable.id) \nwhere \n	u.user.normalizedUserName = :userNormalizedUserName"),Var.valueOf("userNormalizedUserName",
    cronapi.util.Operations.getCurrentUserName()));
    System.out.println(usuarioPertenceComite.getObjectAsString());
    return
Var.VAR_TRUE;
   }
 }.call();
}

}

