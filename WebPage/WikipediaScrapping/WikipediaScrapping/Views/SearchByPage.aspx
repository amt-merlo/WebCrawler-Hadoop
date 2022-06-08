<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="SearchByPage.aspx.cs" Inherits="WikipediaScrapping.Views.SearchByPage" %>
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
                <asp:Button ID="btnViewAll" runat="server" Text="View All" />
            </p>
            <p>
                &nbsp;</p>
            <p>
                &nbsp;&nbsp;&nbsp;
                <asp:GridView ID="GridView1" runat="server" DataSourceID="SqlDataSourcePagina" AutoGenerateColumns="False" DataKeyNames="ID" HorizontalAlign="Center" Width="433px">
                    <Columns>
                        <asp:BoundField HeaderText="ID" DataField="ID" ReadOnly="True" SortExpression="ID" />
                        <asp:BoundField DataField="TITULO" HeaderText="Title" SortExpression="TITULO" />
                        <asp:BoundField DataField="LINK" HeaderText="URL" SortExpression="LINK" />
                        <asp:BoundField DataField="CantSubtitulos" HeaderText="Subtitles" SortExpression="CantSubtitulos" />
                        <asp:BoundField DataField="CantPalabras" HeaderText="Words" SortExpression="CantPalabras" />
                        <asp:BoundField DataField="CantReferencias" HeaderText="References" SortExpression="CantReferencias" />
                        <asp:BoundField DataField="CantPalabrasTitulo" HeaderText="Words in Title" SortExpression="CantPalabrasTitulo" />
                    </Columns>
                    <HeaderStyle HorizontalAlign="Center" VerticalAlign="Middle" Wrap="False" />
                    <PagerStyle HorizontalAlign="Center" />
                    <RowStyle HorizontalAlign="Center" VerticalAlign="Middle" Wrap="False" />
                </asp:GridView>
                <asp:SqlDataSource ID="SqlDataSourcePagina" runat="server" ConnectionString="<%$ ConnectionStrings:wikipediaConnectionString %>" ProviderName="<%$ ConnectionStrings:wikipediaConnectionString.ProviderName %>" SelectCommand="Use wikipedia;
SELECT * FROM Pagina;
"></asp:SqlDataSource>
            </p>
            <p>
                &nbsp;</p>
            <p>&nbsp;</p>
        </div>
    </div>
</asp:Content>
