package blockly.Votacao;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Votos {

public static final int TIMEOUT = 300;

/**
 *
 * @param listaIdItemVoto
 *
 * @author José Zay
 * @since 18/08/2023, 13:12:08
 *
 */
public static Var FinalizarVoto(@ParamMetaData(description = "listaIdItemVoto", id = "fb0d967d") Var listaIdItemVoto) throws Exception {
 return new Callable<Var>() {

   private Var userId = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    userId =
    cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id \nfrom \n	User u  \nwhere \n	u.normalizedUserName = :normalizedUserName"),Var.valueOf("normalizedUserName",
    cronapi.util.Operations.getCurrentUserName()));
    System.out.println(listaIdItemVoto.getObjectAsString());
    if (
    Var.valueOf(
    cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.votou \nfrom \n	User u  \nwhere \n	u.id = :id"),Var.valueOf("id",
    cronapi.util.Operations.getCurrentUserName()))
    .negate().getObjectAsBoolean() &&
    cronapi.database.Operations.query(Var.valueOf("app.entity.Votos"),Var.valueOf("select \n	v.voto \nfrom \n	Votos v  \nwhere \n	v.user.id = :userId"),Var.valueOf("userId",userId)).getObjectAsBoolean()).getObjectAsBoolean()) {
        for (Iterator it_j = listaIdItemVoto.iterator(); it_j.hasNext();) {
            j = Var.valueOf(it_j.next());
            System.out.println(j.getObjectAsString());
            item =
            cronapi.database.Operations.insert(Var.valueOf("app.entity.Votos"),Var.valueOf("user",userId),Var.valueOf("voto",
            cronapi.conversion.Operations.convert(j,
            Var.valueOf("STRING"))));
        } // end for
        cronapi.database.Operations.execute(Var.valueOf("app.entity.User"), Var.valueOf("update \n	User  \nset \n	votou = :votou \nwhere \n	id = :id"),Var.valueOf("votou",
        Var.VAR_TRUE),Var.valueOf("id",userId));
    } else {
      {}
    }
    return Var.VAR_NULL;
   }
 }.call();
}

}

