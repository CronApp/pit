package blockly.Usuario;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class EditarPerfil {

public static final int TIMEOUT = 300;

/**
 *
 * @param nome
 *
 * @author Wesley Miranda De Oliveira
 * @since 08/08/2023, 11:14:32
 *
 */
public static Var SalvarAlteracoes(@ParamMetaData(description = "param_nome", id = "aa4ae81c") Var param_nome) throws Exception {
 return new Callable<Var>() {

   // param
   private Var nome = param_nome;
   // end

   public Var call() throws Exception {
    if (
    cronapi.logic.Operations.isNullOrEmpty(nome).getObjectAsBoolean()) {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"),
        Var.valueOf("Digite seu nome"));
    } else if (
    Var.valueOf(
    Var.valueOf(nome.length()).compareTo(
    Var.valueOf(3)) <= 0).getObjectAsBoolean()) {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"),
        Var.valueOf("Seu nome deve haver mais de 3 caracteres"));
    } else {
        cronapi.database.Operations.execute(Var.valueOf("app.entity.User"), Var.valueOf("update \n	User  \nset \n	name = :name \nwhere \n	userName = :userName"),Var.valueOf("name",nome),Var.valueOf("userName",
        cronapi.util.Operations.getCurrentUserName()));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.hideModal"),
        Var.valueOf("modalEdicaoPerfil"));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

}

