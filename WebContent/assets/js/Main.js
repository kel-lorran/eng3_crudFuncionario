const ajax = (success, fail, operacao,data = null) => {
	let config;
	const urlBase = 'http://localhost:8080/cadFuncionario/';
	
	switch(operacao){
		case 'getAll':
			config = [
				`${urlBase}/ControleFuncionario`,
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
				`${urlBase}/delalt?acao=excluir&id=${data}`,
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
				`${urlBase}/ControleFuncionario`,
				{
					header: {
						"Content-Type": "text/html; charset=utf-8"
					},
					method: 'POST',
					body: data
				}
			];
			break
		case 'atualizar':
			config = [
				`${urlBase}/delalt?id=${data.id}`,
				{
					header: {
						"Content-Type": "text/html; charset=utf-8"
					},
					method: 'POST',
					body: data
				}
			];
			break
	}
	
	fetch(...config).then( resp => resp.text()).then( data => success(data)).catch( fail);
}

const deletarFuncionario = (e) => {
	debugger
	//e.preventDefault();
	alert('isso');
//	let id = e.target.id.replace('funcionario-id-','');
//	
//	ajax(
//			resp => console.log(resp),
//			error => console.log( 'error:', error),
//			'delete',id
//	);
}

ajax(
		resp => document.getElementById('my-table-body').innerHTML = resp,
		error => console.log( 'error:', error),
		'getAll'
);



