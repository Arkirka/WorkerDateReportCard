<!DOCTYPE html>
<html>
<head>
    <meta charset="windows-1251">
    <title>Title</title>
</head>
<body style="font-size: 10,5pt">
   <table>
       <tr>
           <#list table_heads as table_head>
               <td>${table_head_index + 1}</td>
           </#list>
       </tr>

       <#assign currentId = data_list[0].workerId>
       <#assign tempList = data_list>
        <#list 0..<idCount as index>
       <tr>
           <#list data_list>
               <#items as data>
               <#if data.workerId?string?contains(currentId?string)>
                   <#assign x = data_index>
                   <#else >
                       <#continue >
               </#if>
               <td>${data.encoding}</td>
               </#items>
           </#list>
           <#if (index_has_next)>
                   <#assign x = x + 1>
                   <#assign currentId = tempList[x?number].workerId>
           </#if>
       </tr>
        </#list>

   </table>
</body>
</html>

<#function maxListItemSize items>
    <#local max = 0>
    <#list items as item>
        <#local size = item?size>
        <#if max < size>
            <#local max = size>
        </#if>
    </#list>
    <#return max>
</#function>