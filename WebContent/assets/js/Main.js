const ajax = (success, fail, operacao,data = null) => {
	let config;
	const urlBase = 'http://localhost:8080/CadFunc/ControleFuncionario';
	
	switch(operacao){
		case 'getAll':
			config = [
				`${urlBase}?OPERACAO=CONSULTAR&ROTA=consultarDados`,
				{
					header: {
						"Content-Type": "text/html; charset=utf-8"
					},
					method: 'GET'
				}
			];
			break;
		case 'delete':
			config = [
				`${urlBase}?OPERACAO=APAGAR&id=${data}&ROTA=excluirDados`,
				{
					header: {
						"Content-Type": "text/html; charset=utf-8"
					},
					method: 'GET'
				}
			];
			break;
		case 'criar':
			config = [
				`${urlBase}`,
				{
					headers: new Headers({
						"Content-Type": "application/x-www-form-urlencoded"
					}),
					method: 'POST',
					body: (data + '&OPERACAO=SALVAR&ROTA=salvar-funcionario')
				}
			];
			break
		case 'atualizar':
			config = [
				`${urlBase}`,
				{
					headers: new Headers({
						"Content-Type": "application/x-www-form-urlencoded"
					}),
					method: 'POST',
					body: (data + '&OPERACAO=ALTERAR&ROTA=alterarDados')
				}
			];
			break
	}
	
	fetch(...config).then( resp => resp.text()).then( data => success(data)).catch( error => fail(error));
}

const deletarFuncionario = (e) => {
	e.preventDefault();

	let id = e.target.dataset.funcId;
	
	ajax(
			resp => {
				atualizaTabela();
			},
			error => console.log( 'error:', error),
			'delete',id
	);
}

const editarFuncionario = (e) => {
	e.preventDefault();

	let id = e.target.dataset.funcId;
	let tr = document.getElementById(`funcionario-id-${id}`);
	let data = Object.assign([],tr.querySelectorAll(`td`)).filter( (e, i) => i > 1).map( e => e.textContent);
	let inputs = Object.assign([],document.querySelectorAll( `#my-form input`));
	inputs.forEach( ( e, i) => {
		e.value = data[i];
		e.classList.add('valid');
		ligaBtns();
	});
}

const limparForm = ( ) => {
	document.querySelector('#my-form form').reset();
	ligaBtns();
}


const atualizaTabela = () => {
	ajax(
			resp => {
				document.getElementById('my-table-body').innerHTML = resp;
				Object.assign([], document.querySelectorAll('td.type-date')).forEach( e => e.textContent = e.textContent.replace(/-/g,'/') );
				Object.assign([], document.getElementsByClassName('del-btn')).forEach( e => e.addEventListener( 'click', deletarFuncionario));
				Object.assign([], document.getElementsByClassName('edit-btn')).forEach( e => e.addEventListener( 'click', editarFuncionario));
			},
			error => console.log( 'error:', error),
			'getAll'
	);	
}

const ligaBtns = () => {
	let todosInputs = Object.assign([],document.querySelectorAll( `#my-form input`));
	let idPreenchido = !!todosInputs.shift().value;
	let inputs = todosInputs.filter( e => !e.getAttribute('disabled'));
	let todosPreenchidos = !!(inputs.length == (inputs.filter( e => e.classList.contains('valid') || (e.value == 'Ativo') || (e.value == 'Inativo')).length));
	let algumPreenchido = !!inputs.filter( e => e.value !== 'Status:').map( e => e.value).reduce((a, e) => !!a || !!e);	
	
	const atualizaBtnCancel = (flag) => {
		let btn = document.getElementById('btn-cancelar');
		if( !!flag){
			btn.removeAttribute('disabled');
		}else{
			btn.setAttribute('disabled',true);
		}
	}
	
	const atualizaBtnSaveOrUpdate = () => {
		let btnSal = document.getElementById('btn-salvar');
		let btnAtual = document.getElementById('btn-atualizar');
		
		if( idPreenchido && todosPreenchidos){
			btnAtual.parentElement.classList.remove('hide');
			btnSal.parentElement.classList.add('hide');
			btnAtual.removeAttribute('disabled')
		} else if( !idPreenchido && todosPreenchidos){
			btnSal.parentElement.classList.remove('hide');
			btnAtual.parentElement.classList.add('hide');
			btnSal.removeAttribute('disabled')
		} else if( idPreenchido && !todosPreenchidos){
			btnAtual.parentElement.classList.remove('hide');
			btnSal.parentElement.classList.add('hide');
			btnAtual.setAttribute('disabled',true);
		} else if( !idPreenchido && !todosPreenchidos){
			btnSal.parentElement.classList.remove('hide');
			btnAtual.parentElement.classList.add('hide');
			btnSal.setAttribute('disabled',true);
		}
		
	}
	atualizaBtnCancel(algumPreenchido);
	atualizaBtnSaveOrUpdate();
}

const enviaDados = (e) => {
	debugger
	e.preventDefault();
	let inputs = Object.assign([],document.querySelectorAll( `#my-form input`));
	let form = '';
	
	if(! inputs[0].value){
		inputs.shift();
		inputs.forEach( (e,i) => {
			let name = e.name ? e.name : 'txtStatus';
			form += i == 0 ? '' : '&';
			form += `${encodeURIComponent(name)}=${encodeURIComponent(e.value)}`;
		});
		
		ajax(
				resp => {
					atualizaTabela();
					limparForm()
				},
				error => console.log( 'error:', error),
				'criar',form
		);
	} else {
		inputs.forEach( (e,i) => {
			let name = e.name ? e.name : 'txtStatus';
			form += i == 0 ? '' : '&';
			form += `${encodeURIComponent(name)}=${encodeURIComponent(e.value)}`;
		});
		
		ajax(
				resp => {
					atualizaTabela();
					limparForm()
				},
				error => console.log( 'error:', error),
				'atualizar',form
		);
	}
	
}

const actionBtns = (elem) =>{
	if(! elem.target.hasAttribute('disabled')){
		enviaDados(elem);
	}
}


Object.assign([],document.querySelectorAll( `#my-form input`)).forEach( e => e.addEventListener( 'blur', ligaBtns));
document.getElementById('btn-salvar').addEventListener( 'click', (e) => actionBtns(e));
document.getElementById('btn-atualizar').addEventListener( 'click', (e) => actionBtns(e));
document.getElementById('btn-cancelar').addEventListener( 'click', (e) => limparForm());
atualizaTabela();



