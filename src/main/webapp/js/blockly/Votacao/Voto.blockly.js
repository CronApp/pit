window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Votacao = window.blockly.js.blockly.Votacao || {};
window.blockly.js.blockly.Votacao.Voto = window.blockly.js.blockly.Votacao.Voto || {};

/**
 * @function IniciarVotacao
 *
 *
 *
 * @param checkAceitarRegras
 *
 * @author José Zay
 * @since 17/08/2023, 11:20:28
 *
 */
window.blockly.js.blockly.Votacao.Voto.IniciarVotacaoArgs = [{ description: 'checkAceitarRegras', id: 'b8644fae' }];
window.blockly.js.blockly.Votacao.Voto.IniciarVotacao = async function(checkAceitarRegras) {
 var idIdeiaVotada, checado;
  //
  checkAceitarRegras = this.cronapi.conversion.toBoolean(checkAceitarRegras);
  //
  if (checkAceitarRegras) {
    //
    this.cronapi.screen.toggleClass("div-tela-regras-id", 'hidden');
    //
    this.cronapi.screen.toggleClass("div-tela-espera-voto-id", 'hidden');
  } else {
    //
    this.cronapi.screen.notify('error','É necessário aceitar as Regras');
  }
}

/**
 * @function ObtemVoto
 *
 *
 *
 * @param idIdeiaVotada
 * @param checado
 *
 * @author José Zay
 * @since 17/08/2023, 11:20:28
 *
 */
window.blockly.js.blockly.Votacao.Voto.ObtemVotoArgs = [{ description: 'idIdeiaVotada', id: '66436263' }, { description: 'checado', id: '7b36cee4' }];
window.blockly.js.blockly.Votacao.Voto.ObtemVoto = async function(idIdeiaVotada, checado) {
 var lista;
  //
  lista = this.cronapi.screen.getValueOfField("vars.listaVotos");
  //
  if (this.cronapi.conversion.toBoolean(checado)) {
    //
    if (this.cronapi.logic.isNullOrEmpty(lista) || lista.length <= 0) {
      //
      lista = [];
      //
      console.log(lista.length);
      //
      lista.unshift(idIdeiaVotada);
      //
      this.cronapi.screen.changeValueOfField("vars.listaVotos", lista);
      //
      this.cronapi.screen.addClass("div-tela-espera-voto-id", 'hidden');
      //
      this.cronapi.screen.removeClass("div-tela-votados-id", 'hidden');
    } else if (lista.length == 1) {
      //
      console.log(lista.length);
      //
      lista.push(idIdeiaVotada);
      //
      this.cronapi.screen.changeValueOfField("vars.listaVotos", lista);
      //
      this.cronapi.screen.removeClass("div-unico-voto", 'hidden');
    } else {
      //
      console.log(lista.length);
      //
      this.cronapi.screen.notify('success','Selecione no máximo 2 caixas de seleção');
      //
      this.cronapi.screen.addClass("div-unico-voto", 'hidden');
    }
  } else {
    //
    lista.splice(((lista.indexOf(idIdeiaVotada) + 1) - 1), 1);
    //
    this.cronapi.screen.changeValueOfField("vars.listaVotos", lista);
    //
    if (lista.length <= 0) {
      //
      this.cronapi.screen.removeClass("div-tela-espera-voto-id", 'hidden');
      //
      this.cronapi.screen.addClass("div-tela-votados-id", 'hidden');
      //
      this.cronapi.screen.addClass("div-unico-voto", 'hidden');
    } else if (lista.length == 1) {
      //
      this.cronapi.screen.removeClass("div-unico-voto", 'hidden');
    } else {
    }
    //
    console.log(lista.length);
  }
}
