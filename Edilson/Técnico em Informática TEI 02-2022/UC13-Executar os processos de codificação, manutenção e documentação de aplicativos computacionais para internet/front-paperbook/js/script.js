// referenciar os controles: input nome, descricao e btncadastrar
let nome = document.getElementById("nome");
let descricao = document.getElementById("descricao");
let btncadastrar = document.getElementById("btncadastrar");

//realizar o cadastro quando o botão for clicado
btncadastrar.onclick = ()=>{
    fetch("http://10.26.44.12:5000/api/v1/categoria/cadastrar", {
        method:"POST",
        headers:{
            "accept":"application/json",
            "content-type":"application/json"
        },
        body:JSON.stringify({
            nomecategoria:nome.value,
            descricao:descricao.value
        })
    })
    .then((response)=>response.json())
    .then((dados)=>alert(dados))
    .catch((error)=>console.error(error))
}

// Exibir as categorias cadastradas
function exibirCategorias(){
    let saida = "";
    fetch("http://10.26.44.12:5000/api/v1/categoria/listar")
    .then((response)=>response.json())
    .then((dados)=>{
        dados.map((itens,ix)=>{
            saida+=`<tr><td>${itens.idcategoria}</td>
                    <td>${itens.nomecategoria}</td>
                    <td>${itens.descricao}</td>
                    <td>
                        <a href=# onclick="atualizar('${itens.idcategoria}','${itens.nomecategoria}','${itens.descricao}')">
                        Atualizar
                        </a>
                    </td>
                    <td>
                        <a href=# onclick=apagar('${itens.idcategoria}')>
                        Apagar
                        </a>
                    </td>
                    </tr>`;
        })
        document.getElementsByTagName("tbody")[0].innerHTML=saida;
    }).catch((error)=>console.error("Erro na api "+error))
}

function atualizar(id, cat , desc){
    
    nome.value = cat;
    descricao.value = desc


}
function apagar(id){
    fetch("http://10.26.44.12:5000/api/v1/categoria/apagar/"+id,{method:"DELETE"})
    .then((response)=>response.json())
    .then((dados)=>{
       
    }
    ).catch((error)=>console.error("Erro na aplicação "+error))
    alert("A categoria foi apagada. Atualize a página")
    window.location.reload()
}