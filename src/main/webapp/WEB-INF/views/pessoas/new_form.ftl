<@content for="title">Cadastrar Pessoa</@content>

<span class="error_message"><@flash name="message"/></span>
<h2>Cadastrar Pessoa</h2>


<@form action="create" method="post">
    <table style="margin:30px">
        <tr>
            <td>Nome Pessoa</td>
            <td><input type="text" name="name" value="${(flasher.params.name)!}"> *
                            <span class="error">${(flasher.errors.name)!}</span>
            </td>
        </tr>
        <tr>
            <td>Sobrenome Pessoa:</td>
            <td><input type="text" name="last_name" value="${(flasher.params.last_name)!}"> *
                            <span class="error">${(flasher.errors.last_name)!}</span>
            </td>

            <td><@link_to>Cancel</@link_to> | <input type="submit" value="Submit"></td>

        </tr>
    </table>
</@form>
