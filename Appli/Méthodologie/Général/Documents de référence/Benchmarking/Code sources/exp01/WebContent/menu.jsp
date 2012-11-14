<%!
	String op[] = {"Nouveau Produit", "Rechercher Produit", "Liste de Produits"};
	String links[] = {"NouveayProduit.html","RechercheProduit.html","ListeProduit.html"};
%>

<ol>
	<%
		for(int i=0;i<op.length;i++) {
	%>
	<li><a href="<%=links[i] %>"><%=op[i] %></a></li>
	<%
		}
	%>
	
</ol>