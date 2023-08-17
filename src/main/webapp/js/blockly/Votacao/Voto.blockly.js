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
 * @since 16/08/2023, 16:00:58
 *
 */
window.blockly.js.blockly.Votacao.Voto.IniciarVotacaoArgs = [{ description: 'checkAceitarRegras', id: 'b8644fae' }];
window.blockly.js.blockly.Votacao.Voto.IniciarVotacao = async function(checkAceitarRegras) {
 var checkbox, x, idIdeiaVotada, checado;
  //
  checkAceitarRegras = this.cronapi.conversion.toBoolean(checkAceitarRegras);
  //
  if (checkAceitarRegras) {
    //
    this.cronapi.screen.toggleClass("check-aceitar-regras", 'hidden');
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
 * @since 16/08/2023, 16:00:58
 *
 */
window.blockly.js.blockly.Votacao.Voto.ObtemVotoArgs = [{ description: 'idIdeiaVotada', id: '66436263' }, { description: 'checado', id: '7b36cee4' }];
window.blockly.js.blockly.Votacao.Voto.ObtemVoto = async function(idIdeiaVotada, checado) {
 var checkbox, x, lista;
  //
  lista = this.cronapi.screen.getValueOfField("vars.listaVotos");
  //
  console.log(checado);
  //
  if (this.cronapi.conversion.toBoolean(checado)) {
    //
    if (this.cronapi.logic.isNullOrEmpty(lista)) {
      //
      lista = [];
      //
      lista.unshift(idIdeiaVotada);
      //
      this.cronapi.screen.changeValueOfField("vars.listaVotos", lista);
      //
      this.cronapi.screen.toggleClass("div-tela-espera-voto-id", 'hidden');
      //
      this.cronapi.screen.toggleClass("div-tela-votados-id", 'hidden');
    } else if (lista.length < 2) {
      //
      lista.push(idIdeiaVotada);
      //
      this.cronapi.screen.changeValueOfField("vars.listaVotos", lista);
    } else {
      //
      this.cronapi.screen.notify('success','Selecione no máximo 2 caixas de seleção');
    }
  } else {
    //
    lista.splice(((lista.indexOf(idIdeiaVotada) + 1) - 1), 1);
    //
    console.log(lista.indexOf(idIdeiaVotada) + 1);
    //
    this.cronapi.screen.changeValueOfField("vars.listaVotos", lista);
  }
  //
  console.log(lista);
}
