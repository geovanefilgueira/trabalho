<%-- 
    Document   : listando
    Created on : 19/10/2018, 21:27:43
    Author     : cawil
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Painel de Administração</title>
        
        <style>
            *{margin: 0px; padding:0px; font-family: arial; size: 16px;}
            body{ background: #E8E8E8}
            nav{width: 100%; min-height:10vh; background:#00BFFF;}
            header,nav{
                display:flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
            }
            table{width:80%;background: #FFF;}
            .topicostab{background: #9C9C9C; text-align: center;}
            a{text-decoration:none;}
        </style>
    </head>
    <body>
        <nav>
            <h2>Cadastrar Novo Funcionario</h2>
            <form action="Cadastrar" method="post" >
                      Matricula: <input type="text" name="fmatricula"  >
                      Nome: <input type="text" name="fnome"  >
                      Senha: <input type="password" name="fsenha"  >
                      <input type="submit" value="Cadastrar" >
                      <input type="reset" value="Limpar" >
             </form> 
        </nav>
        
       <%
           Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/ultimotrabalhoanderson","root","");
            PreparedStatement  p =  c.prepareStatement("select * from funcionarios ");
            ResultSet r =   p.executeQuery() ; 
            
       %>
       <br><br>
       <header>
           <h2>Funcionarios Existentes</h2>
            <table border="0">
                <tr class="topicostab">
                    <td> Matricula </td> 
                    <td> Nome </td> 
                    <td> Senha</td>
                    <td> Status</td>
                    <td> Ação </td> 
                 </tr> 
                 
                    <%while (r.next()) { 
                    
                                    
                    %>   
                            
                        <tr> 
                            <td> <%= r.getString("bmatricula") %> </td> 
                            <td> <%= r.getString("bnome") %> </td> 
                            <td> <%= r.getString("bsenha") %> </td> 
                            <td><%=r.getString("bstatus") %> </td>          
                            <td><% out.print("<a href='Cadastrar?id=" + r.getString("id") + "' > Excluir </a>"); %> </td>
                        </tr> 
                       
                        <% }  %>
    
            </table>
                        
       </header>




    </body>
</html>

