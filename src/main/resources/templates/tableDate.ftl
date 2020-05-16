<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body style="font-size: 10,5pt">
   <table>
       <tr>
           <#list table_heads as table_head>
               <td>${table_head_index + 1}</td>
           </#list>
       </tr>
       <tr>
           <#list table_heads as table_head>
               <td>${table_head_index + 1}</td>
           </#list>
       </tr>
   </table>
</body>
</html>