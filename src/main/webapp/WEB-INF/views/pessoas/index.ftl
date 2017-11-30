<@content for="title">Pessoas</@content>

<@link_to action="new_form">Cadastrar Pessoa</@link_to>

<table>
	<tr>
		<td>Nome</td>
		<td>Sobrenome</td>
		<td>Edit</td>
	</tr>

	<#list pessoas as pessoa>
		<tr>
			<td>${pessoa.name}</td>
			<td>${pessoa.last_name}</td>
			<td>
				<@form id=pessoa.id action="delete" method="delete" html_id=pessoa.id>
					<button type="submit">Delete</button>
				</@form>
			</td>
		</tr>
	</#list>
</table>
