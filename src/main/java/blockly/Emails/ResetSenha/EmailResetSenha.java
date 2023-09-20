package blockly.Emails.ResetSenha;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", put = "Public")
public class EmailResetSenha {

public static final int TIMEOUT = 300;

/**
 *
 * Email
 *
 * @param email
 *
 * @author José Zay
 * @since 20/09/2023, 09:41:43
 *
 */
public static Var EnviaEmailResetSenha(@ParamMetaData(description = "email", id = "c3852ac6") Var email) throws Exception {
 return new Callable<Var>() {

   private Var ret = Var.VAR_NULL;
   private Var usuario = Var.VAR_NULL;
   private Var idReset = Var.VAR_NULL;
   private Var nomeUsuario = Var.VAR_NULL;
   private Var inserirReset = Var.VAR_NULL;
   private Var urlReset = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         if (
        cronapi.validation.Operations.validateEmail(email)
        .negate().getObjectAsBoolean()) {
            ret =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_FALSE) , Var.valueOf("mensagem",
            Var.valueOf("O e-mail informado é inválido")));
        } else {
            usuario =
            cronapi.list.Operations.getFirst((
            cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id \nfrom \n	User u \nwhere \n	u.email = :email"),Var.valueOf("email",email))));
            if (
            cronapi.logic.Operations.isNullOrEmpty(usuario).getObjectAsBoolean()) {
                ret =
                cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
                Var.VAR_FALSE) , Var.valueOf("mensagem",
                Var.valueOf("O e-mail informado não está cadastrado")));
            } else {
                idReset =
                cronapi.util.Operations.generateUUID();
                nomeUsuario =
                cronapi.list.Operations.getFirst((
                cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.name \nfrom \n	User u \nwhere \n	u.email = :email"),Var.valueOf("email",email))));
                cronapi.database.Operations.beginTransaction(Var.valueOf("app"));
                cronapi.database.Operations.execute(Var.valueOf("app.entity.ResetSenha"), Var.valueOf("delete from \n	\n	ResetSenha  \nwhere \n	user.id = :id"),Var.valueOf("id",usuario));
                cronapi.database.Operations.commitTransaction(Var.valueOf("app"));
                inserirReset =
                cronapi.database.Operations.insert(Var.valueOf("app.entity.ResetSenha"),Var.valueOf("id",idReset),Var.valueOf("dataLimite",
                cronapi.dateTime.Operations.incHour(
                cronapi.dateTime.Operations.getNow(),
                Var.valueOf(1))),Var.valueOf("user",usuario));
                urlReset =
                Var.valueOf(
                cronapi.util.Operations.getBaseUrl().getObjectAsString() +
                Var.valueOf("/#/reset-senha?reset=").getObjectAsString() +
                idReset.getObjectAsString());
                System.out.println(
                Var.valueOf("url criada").getObjectAsString());
                System.out.println(urlReset.getObjectAsString());
                item =
                cronapi.util.Operations.callBlockly(Var.valueOf("blockly.Emails.Email:EnviarEmailComBotao"), Var.valueOf("9aa6d127", email), Var.valueOf("6ac3bc79", nomeUsuario), Var.valueOf("b4be60df",
                Var.valueOf("Foi solicitado uma alteração de senha para o sistema <b>Prêmio de Inovação Techne (PIT)</b>. Caso você não tenha solicitado esta ação, essa mensagem pode ser ignorada.")), Var.valueOf("58c17ec5",
                Var.valueOf("Alteração de senha")), Var.valueOf("37f93f43",
                Var.valueOf("PIT | Alteração de senha")), Var.valueOf("1ba68f9f", urlReset), Var.valueOf("615e5d16",
                Var.valueOf("Clique aqui para alterar sua senha")));
                ret =
                cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
                Var.VAR_TRUE) , Var.valueOf("mensagem",
                Var.valueOf("Foram enviadas instruções sobre a alteração para seu e-mail.")));
            }
        }
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.throwException(err);
     }
    return ret;
   }
 }.call();
}

}

