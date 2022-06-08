<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="UniquePage.aspx.cs" Inherits="WikipediaScrapping.Views.UniquePage" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
      <div class="jumbotron">
        <h1 class="text-center">Wikipedia WebScrapper</h1>
        <p class="lead" style="text-align: center; font-size: small">Databases II | Final Project</p>
    </div>

    <div >
        <div style="text-align: center" >
            <h2>Search by page</h2>
            <p>
                <asp:TextBox ID="txtBoxPagina" runat="server"></asp:TextBox>
&nbsp;&nbsp;&nbsp;
                <asp:Button ID="btnSearchWord" runat="server" Text="Search" OnClick="btnSearchWord_Click" />
            &nbsp;
                <asp:Button ID="btnViewAll" runat="server" Text="View All" OnClick="btnViewAll_Click" />
            </p>
            <p>
                &nbsp;</p>
            <p>
                &nbsp;&nbsp;&nbsp;
                <asp:GridView ID="GridView1" runat="server" DataSourceID="SqlDataSourcePagina" AutoGenerateColumns="False" DataKeyNames="ID" Width="704px">
                    <Columns>
                        <asp:BoundField HeaderText="ID" DataField="ID" ReadOnly="True" SortExpression="ID" />
                        <asp:BoundField DataField="TITULO" HeaderText="Titulo" SortExpression="TITULO" />
                        <asp:BoundField DataField="LINK" HeaderText="Link" SortExpression="LINK" />
                        <asp:BoundField DataField="CantSubtitulos" HeaderText="Subtitulos" SortExpression="CantSubtitulos" />
                        <asp:BoundField DataField="CantPalabras" HeaderText="Palabras" SortExpression="CantPalabras" />
                        <asp:BoundField DataField="CantReferencias" HeaderText="Referencias" SortExpression="CantReferencias" />
                        <asp:BoundField DataField="CantPalabrasTitulo" HeaderText="Palabras en el Titulo" SortExpression="CantPalabrasTitulo" />
                    </Columns>
                </asp:GridView>
                <asp:SqlDataSource ID="SqlDataSourcePagina" runat="server" ConnectionString="<%$ ConnectionStrings:wikipediaConnectionString %>" ProviderName="<%$ ConnectionStrings:wikipediaConnectionString.ProviderName %>" SelectCommand="USE wikipedia; 
SELECT * FROM pagina;"></asp:SqlDataSource>
            </p>
            <p>
                &nbsp;</p>
            <p>&nbsp;</p>
        </div>
    </div>
</asp:Content>
