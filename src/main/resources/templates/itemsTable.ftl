<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

<h3>Item List</h3>
<br>
<div>
    <a href="/web/item/create"  class="btn btn-warning">Create</a><br>
    <table class="table table-hover table-dark">
        <thead>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Created</th>
            <th>Modified</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <#list items as element> <!--Цикл по всем element !! -->
            <!--Для каждого element в списке items , который мы получили
             из контроллера . -----------------------------
             Формируем строку <tr>. У этой строки есть ..5.. ячеек
              Каждая ичейка является полем ..елемента.. !
              (id)(name) т.д !!! -->
            <tr>
                <td>${element.id}</td>
                <td>${element.name}</td>
                <td>${element.description}</td>
                <td>${element.created_at}</td>
                <td>${element.modified_at}</td>
                <td><a href="/web/item/delete/${element.id}" class="btn btn-outline-danger">Delete</a></td>
                <td><a href="/web/item/update/${element.id}" class="btn btn-outline-success">Edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>


</div>
</body>
</html>