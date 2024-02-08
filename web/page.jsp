<%-- Document : page Created on : 11 déc. 2023, 15:04:08 Author : sergi --%>
    <%@page contentType="text/html" pageEncoding="UTF-8" import="Models.User,java.util.Vector" %>

        <% try{ 
                if(request.getAttribute("data")!=null){
                Vector<User> dataUser = (Vector<User>)request.getAttribute("data");
                
                    for(int i = 0;i<dataUser.size();i++){
                    out.println(dataUser.get(i).getEmail());
                }
            }
            %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv=" Content-Type" content="text/html; charset=UTF-8">
                <title>Sergio</title>
            </head>

            <body>

            </body>

            </html>

            <% }catch(Exception e){ System.out.println("error page jsp"); } %>