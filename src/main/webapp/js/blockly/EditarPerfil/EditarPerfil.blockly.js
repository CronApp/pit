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
 * @since 28/08/2023, 13:35:03
 *
 */
window.blockly.js.blockly.EditarPerfil.EditarPerfil.NotificacaoLoginArgs = [];
window.blockly.js.blockly.EditarPerfil.EditarPerfil.NotificacaoLogin = async function() {

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
 * @since 28/08/2023, 13:35:03
 *
 */
window.blockly.js.blockly.EditarPerfil.EditarPerfil.PreencheCampoNomeArgs = [];
window.blockly.js.blockly.EditarPerfil.EditarPerfil.PreencheCampoNome = async function() {

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
 * @since 28/08/2023, 13:35:03
 *
 */
window.blockly.js.blockly.EditarPerfil.EditarPerfil.FecharModalEditarPerfilArgs = [];
window.blockly.js.blockly.EditarPerfil.EditarPerfil.FecharModalEditarPerfil = async function() {

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
 * @since 28/08/2023, 13:35:03
 *
 */
window.blockly.js.blockly.EditarPerfil.EditarPerfil.IniciarModalEditarArgs = [];
window.blockly.js.blockly.EditarPerfil.EditarPerfil.IniciarModalEditar = async function() {

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
 * @since 28/08/2023, 13:35:03
 *
 */
window.blockly.js.blockly.EditarPerfil.EditarPerfil.IniciarModalEditarSenhaArgs = [];
window.blockly.js.blockly.EditarPerfil.EditarPerfil.IniciarModalEditarSenha = async function() {

  //
  this.cronapi.screen.showModal("modalPassword");
  //
  this.cronapi.screen.hideModal("modalEdicaoPerfil");
}

/**
 * @function validarAlterarSenha
 *
 * normalmente, no elemento que chama esta função, deveria ter o
 * seguinte atributo: 'ng-click="changePassword()"' para efetuar
 * validações extras foi removido este elemento, e chamado a
 * partir do javascript pegando o escopo do angular e chamando
 * esta função no bloco Executa javascript desta função.
 *
 *
 * @author José Zay
 * @since 28/08/2023, 13:35:03
 *
 */
window.blockly.js.blockly.EditarPerfil.EditarPerfil.validarAlterarSenhaArgs = [];
window.blockly.js.blockly.EditarPerfil.EditarPerfil.validarAlterarSenha = async function() {

  //
  this.cronapi.util.executeJavascriptNoReturn('angular.element(document.getElementById(\'btn-override-salvar-senha\')).scope().changePassword()');
}
