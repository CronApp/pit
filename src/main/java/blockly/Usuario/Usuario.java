package blockly.Usuario;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", delete = "Public", put = "Public")
public class Usuario {

public static final int TIMEOUT = 300;

/**
 *
 * @param email
 * @param senha
 * @param nome
 *
 * @author José Zay
 * @since 09/11/2023, 13:41:34
 *
 */
public static Var CadastrarUsuario(@ParamMetaData(description = "email", id = "53b42e7f") Var email, @ParamMetaData(description = "param_senha", id = "2bc04d37") Var param_senha, @ParamMetaData(description = "nome", id = "fca923a9") Var nome) throws Exception {
 return new Callable<Var>() {

   // param
   private Var senha = param_senha;
   // end
   private Var id_usuario = Var.VAR_NULL;
   private Var response = Var.VAR_NULL;
   private Var usr = Var.VAR_NULL;
   private Var appl = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         id_usuario =
        cronapi.util.Operations.generateUUID();
        if (
        Var.valueOf(
        cronapi.validation.Operations.validateEmail(email)
        .negate().getObjectAsBoolean()).getObjectAsBoolean()) {
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_FALSE) , Var.valueOf("mensagem",
            Var.valueOf("E-mail inválido")));
        } else if (
        Var.valueOf(
        Var.valueOf(
        Var.valueOf(email.getObjectAsString().indexOf(
        Var.valueOf("@lyceum.com.br").getObjectAsString()) + 1).equals(
        Var.valueOf(0))).getObjectAsBoolean() &&
        Var.valueOf(
        Var.valueOf(email.getObjectAsString().indexOf(
        Var.valueOf("@hygia.com.br").getObjectAsString()) + 1).equals(
        Var.valueOf(0))).getObjectAsBoolean() &&
        Var.valueOf(
        Var.valueOf(email.getObjectAsString().indexOf(
        Var.valueOf("@ergon.com.br").getObjectAsString()) + 1).equals(
        Var.valueOf(0))).getObjectAsBoolean() &&
        Var.valueOf(
        Var.valueOf(email.getObjectAsString().indexOf(
        Var.valueOf("@cronapp.io").getObjectAsString()) + 1).equals(
        Var.valueOf(0))).getObjectAsBoolean() &&
        Var.valueOf(
        Var.valueOf(email.getObjectAsString().indexOf(
        Var.valueOf("@techne.com.br").getObjectAsString()) + 1).equals(
        Var.valueOf(0))).getObjectAsBoolean()).getObjectAsBoolean()) {
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_FALSE) , Var.valueOf("mensagem",
            Var.valueOf("O domínio do e-mail não faz parte da Techne.")));
        } else if (
        Var.valueOf(
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	COUNT(u) \nfrom \n	User u \nwhere \n	u.email = :email"),Var.valueOf("email",email)))).compareTo(
        Var.valueOf(0)) > 0).getObjectAsBoolean()) {
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_FALSE) , Var.valueOf("mensagem",
            Var.valueOf("E-mail já cadastrado.")));
        } else if (
        cronapi.logic.Operations.isNullOrEmpty(senha).getObjectAsBoolean()) {
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_FALSE) , Var.valueOf("mensagem",
            Var.valueOf("Digite uma senha.")));
        } else if (
        Var.valueOf(
        Var.valueOf(senha.length()).compareTo(
        Var.valueOf(8)) < 0).getObjectAsBoolean()) {
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_FALSE) , Var.valueOf("mensagem",
            Var.valueOf("O tamanho da senha deve possuir ao menos 8 caracteres.")));
        } else if (
        cronapi.regex.Operations.validateTextWithRegexUnscape(senha,
        Var.valueOf("^(?=.*[a-zA-Z])(?=.*\\d).+$"),
        Var.valueOf("CASE_INSENSITIVE"))
        .negate().getObjectAsBoolean()) {
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_FALSE) , Var.valueOf("mensagem",
            Var.valueOf("A senha deve conter números e letras.")));
        } else if (
        cronapi.regex.Operations.validateTextWithRegexUnscape(senha,
        Var.valueOf("^(?=.*[A-Z]).+$"),
        Var.valueOf("UNICODE_CASE"))
        .negate().getObjectAsBoolean()) {
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_FALSE) , Var.valueOf("mensagem",
            Var.valueOf("A senha deve conter ao menos uma letra maiúscula.")));
        } else if (
        cronapi.regex.Operations.validateTextWithRegexUnscape(senha,
        Var.valueOf("^(?=.*[\\W_]).+$"),
        Var.valueOf("CASE_INSENSITIVE"))
        .negate().getObjectAsBoolean()) {
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_FALSE) , Var.valueOf("mensagem",
            Var.valueOf("A senha deve conter ao menos um caractere especial.")));
        } else {
            cronapi.database.Operations.beginTransaction(Var.valueOf("app"));
            usr =
            cronapi.database.Operations.insert(Var.valueOf("app.entity.User"),Var.valueOf("email",email),Var.valueOf("name",nome),Var.valueOf("normalizedEmail",email),Var.valueOf("normalizedUserName",email),Var.valueOf("password",senha),Var.valueOf("userName",email),Var.valueOf("id",id_usuario));
            cronapi.database.Operations.commitTransaction(Var.valueOf("app"));
            appl =
            cronapi.database.Operations.insert(Var.valueOf("app.entity.ApplicationUser"),Var.valueOf("application",
            cronapi.util.Operations.getApplicationId()),Var.valueOf("user",id_usuario));
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_TRUE) , Var.valueOf("mensagem",
            Var.valueOf("Conta criada com sucesso.")));
        }
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro ao cadastrar usuário"),
        Var.valueOf(""),
        Var.valueOf("Trace"), err);
        response =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE) , Var.valueOf("mensagem",
        Var.valueOf("Falha ao criar usuário, contate um administrador")));
     }
    return response;
   }
 }.call();
}

/**
 *
 * @param email
 *
 * @author José Zay
 * @since 09/11/2023, 13:41:34
 *
 */
public static void ResetSenha(@ParamMetaData(description = "email", id = "ae582bec") Var email) throws Exception {
  new Callable<Var>() {

   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    item =
    cronapi.authentication.Operations.defaultResetPassword(email,
    Var.valueOf("https://acesso.cronapp.io/img/layers.png"),
    Var.valueOf("https://acesso.cronapp.io/img/layers.png"),
    Var.VAR_FALSE);
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param username
 * @param password
 *
 * @author José Zay
 * @since 09/11/2023, 13:41:34
 *
 */
public static Var login(@ParamMetaData(description = "username", id = "eb4f9fa9") Var username, @ParamMetaData(description = "password", id = "59713897") Var password) throws Exception {
 return new Callable<Var>() {

   private Var response = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;
   private Var auth = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         auth =
        cronapi.util.Operations.getURLFromOthers(
        Var.valueOf("POST"),
        Var.valueOf("application/json"),
        Var.valueOf(
        cronapi.util.Operations.getBaseUrl().getObjectAsString() +
        Var.valueOf("/auth?username=").getObjectAsString() +
        username.getObjectAsString() +
        Var.valueOf("&password=").getObjectAsString() +
        password.getObjectAsString()), Var.VAR_NULL, Var.VAR_NULL,
        cronapi.map.Operations.createObjectMap(),
        Var.valueOf(""),
        Var.valueOf("BODY"));
        response =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_TRUE) , Var.valueOf("dados",auth));
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.throwException(err);
     }
    return response;
   }
 }.call();
}

}

