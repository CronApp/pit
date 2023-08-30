window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.EditarPerfil = window.blockly.js.blockly.EditarPerfil || {};
window.blockly.js.blockly.EditarPerfil.EditarPerfil = window.blockly.js.blockly.EditarPerfil.EditarPerfil || {};

/**
 * @function NotificacaoLogin
 *
 *
 *
 *
 * @author José Zay
 * @since 30/08/2023, 16:53:48
 *
 */
window.blockly.js.blockly.EditarPerfil.EditarPerfil.NotificacaoLoginArgs = [];
window.blockly.js.blockly.EditarPerfil.EditarPerfil.NotificacaoLogin = async function() {
 var oldPassword, newPassword, newPasswordConfirmation;
  //
  this.cronapi.notification.customNotify('success', ['Seja bem-vindo(a), ',this.cronapi.util.getUserName(),', ao Sistema de Votação PIT (Prêmio de Inovação Techne).'].join(''), 'fade', 'bottom', 'right', 'true');
}

/**
 * @function PreencheCampoNome
 *
 *
 *
 *
 * @author José Zay
 * @since 30/08/2023, 16:53:48
 *
 */
window.blockly.js.blockly.EditarPerfil.EditarPerfil.PreencheCampoNomeArgs = [];
window.blockly.js.blockly.EditarPerfil.EditarPerfil.PreencheCampoNome = async function() {
 var oldPassword, newPassword, newPasswordConfirmation;
  //
  this.cronapi.screen.changeValueOfField("vars.nomeUsuarioEdicao", this.cronapi.util.getUserName());
  //
  (await this.cronapi.client('blockly.js.blockly.EditarPerfil.EditarPerfil.NotificacaoLogin').run());
}

/**
 * @function FecharModalEditarPerfil
 *
 *
 *
 *
 * @author José Zay
 * @since 30/08/2023, 16:53:48
 *
 */
window.blockly.js.blockly.EditarPerfil.EditarPerfil.FecharModalEditarPerfilArgs = [];
window.blockly.js.blockly.EditarPerfil.EditarPerfil.FecharModalEditarPerfil = async function() {
 var oldPassword, newPassword, newPasswordConfirmation;
  //
  this.cronapi.screen.hideModal("modalEdicaoPerfil");
}

/**
 * @function IniciarModalEditar
 *
 *
 *
 *
 * @author José Zay
 * @since 30/08/2023, 16:53:48
 *
 */
window.blockly.js.blockly.EditarPerfil.EditarPerfil.IniciarModalEditarArgs = [];
window.blockly.js.blockly.EditarPerfil.EditarPerfil.IniciarModalEditar = async function() {
 var oldPassword, newPassword, newPasswordConfirmation;
  //
  this.cronapi.screen.showModal("modalEdicaoPerfil");
}

/**
 * @function IniciarModalEditarSenha
 *
 *
 *
 *
 * @author José Zay
 * @since 30/08/2023, 16:53:48
 *
 */
window.blockly.js.blockly.EditarPerfil.EditarPerfil.IniciarModalEditarSenhaArgs = [];
window.blockly.js.blockly.EditarPerfil.EditarPerfil.IniciarModalEditarSenha = async function() {
 var oldPassword, newPassword, newPasswordConfirmation;
  //
  this.cronapi.screen.showModal("modalPassword");
  //
  this.cronapi.screen.hideModal("modalEdicaoPerfil");
}

/**
 * @function ValidarAlterarSenha
 *
 * normalmente, no elemento que chama esta função, deveria ter o
 * seguinte atributo: 'ng-click="changePassword()"' para efetuar
 * validações extras foi removido este elemento, e chamado a partir
 * do javascript pegando o escopo do angular e chamando esta
 * função no bloco Executa javascript desta função, já que não
 * foi possível (por hora) alterar esta função diretamente.
 *
 *
 * @author José Zay
 * @since 30/08/2023, 16:53:48
 *
 */
window.blockly.js.blockly.EditarPerfil.EditarPerfil.ValidarAlterarSenhaArgs = [];
window.blockly.js.blockly.EditarPerfil.EditarPerfil.ValidarAlterarSenha = async function() {
 var oldPassword, newPassword, newPasswordConfirmation;
  //
  oldPassword = this.cronapi.util.executeJavascriptReturn('document.getElementById(\"oldPassword\").value');
  //
  newPassword = this.cronapi.util.executeJavascriptReturn('document.getElementById(\"newPassword\").value');
  //
  newPasswordConfirmation = this.cronapi.util.executeJavascriptReturn('document.getElementById(\"newPasswordConfirmation\").value');
  // Aqui são feitas as validações que faltam dentro da chamada changePassword.
  if (this.cronapi.logic.isNullOrEmpty(oldPassword)) {
    //
    this.cronapi.screen.notify('error','Senha Anterior não pode estar vazio.');
    //
    this.cronapi.screen.focusComponent("oldPassword");
  } else if (this.cronapi.logic.isNullOrEmpty(newPassword)) {
    //
    this.cronapi.screen.notify('error','Nova Senha não pode estar vazio.');
    //
    this.cronapi.screen.focusComponent("newPassword");
  } else if (newPassword.length < 8) {
    //
    this.cronapi.screen.notify('error','O tamanho da senha deve possuir ao menos 8 caracteres.');
    //
    this.cronapi.screen.focusComponent("newPassword");
  } else if (!this.cronapi.regex.validateTextWithRegex(newPassword, '^(?=.*[a-zA-Z])(?=.*\\d).+$', '-')) {
    //
    this.cronapi.screen.notify('error','A senha deve conter números e letras.');
    //
    this.cronapi.screen.focusComponent("newPassword");
  } else if (!this.cronapi.regex.validateTextWithRegex(newPassword, '^(?=.*[A-Z]).+$', '-')) {
    //
    this.cronapi.screen.notify('error','A senha deve conter ao menos uma letra maiúscula.');
    //
    this.cronapi.screen.focusComponent("newPassword");
  } else if (!this.cronapi.regex.validateTextWithRegex(newPassword, '^(?=.*[\\W_]).+$', '-')) {
    //
    this.cronapi.screen.notify('error','A senha deve conter ao menos um caractere especial.');
    //
    this.cronapi.screen.focusComponent("newPassword");
  } else if (newPassword != newPasswordConfirmation) {
    //
    this.cronapi.screen.notify('error','Os campos Nova Senha e Confirmação não coincidem.');
    //
    this.cronapi.screen.focusComponent("newPasswordConfirmation");
  } else {
    //
    this.cronapi.util.executeJavascriptNoReturn('angular.element(document.getElementById(\'btn-override-salvar-senha\')).scope().changePassword()');
  }
}
