<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="SearchByWord.aspx.cs" Inherits="WikipediaScrapping.Views.SearchByWord" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <div class="jumbotron">
        <h1 class="text-center">Wikipedia WebScrapper</h1>
        <p class="lead" style="text-align: center; font-size: small">Databases II | Final Project</p>
    </div>

    <div >
        <div style="text-align: center" >
            <h2>Search by word</h2>
            <p>
                <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
&nbsp;&nbsp;&nbsp;
                <asp:Button ID="btnSearchWord" runat="server" Text="Search" />
            &nbsp;
                <asp:Button ID="btnViewAll" runat="server" Text="View All" />
            </p>
            <p>
                &nbsp;&nbsp;&nbsp;
                <asp:GridView ID="GridView1" runat="server" DataSourceID="SqlDataSourcePagina" AutoGenerateColumns="False" DataKeyNames="ID">
                    <Columns>
                        <asp:BoundField HeaderText="ID" DataField="ID" InsertVisible="False" ReadOnly="True" SortExpression="ID" />
                        <asp:BoundField DataField="NumTop" HeaderText="Top" SortExpression="NumTop" />
                        <asp:BoundField DataField="Palabra" HeaderText="Palabra" SortExpression="Palabra" />
                        <asp:BoundField DataField="Apariciones" HeaderText="Apariciones" SortExpression="Apariciones" />
                        <asp:BoundField DataField="ID_Pagina" HeaderText="ID_Pagina" SortExpression="ID_Pagina" />
                    </Columns>
                </asp:GridView>
                <asp:SqlDataSource ID="SqlDataSourcePagina" runat="server" ConnectionString="<%$ ConnectionStrings:wikipediaConnectionString %>" ProviderName="<%$ ConnectionStrings:wikipediaConnectionString.ProviderName %>" SelectCommand="Use wikipedia;
SELECT * FROM Populares"></asp:SqlDataSource>
            </p>
            <p>
                &nbsp;</p>
            <p>&nbsp;</p>
        </div>
    </div>
</asp:Content>
