<@content for="title">Pagina Inicial</@content>

<@link_to action="new_form">Add nova pessoa.</@link_to>

<table>
	<tr>
		<td>Nome</td>
		<td>Sobrenome</td>
		<td>Edit</td>
	</tr>

	<#list persons as person>
		<tr>
			<td>${person.name}</td>
			<td>${person.last_name}</td>
			<td>
				<@form id=person.id action="delete" method="delete" html_id=person.id>
					<button type="submit">Delete</button>
				</@form>
			</td>
		</tr>
	</#list>
</table>
