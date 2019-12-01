import br.com.finalcraft.unesp.java.jogodamas.webservice.sql.BancoDeDados;
import br.com.finalcraft.unesp.java.jogodamas.webservice.sql.data.SQLPlayer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClassificasaoServlet", urlPatterns = {"classificacao"}, loadOnStartup = 1)
public class ClassificasaoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Classificação</title>");
            out.println("<style>"
                    + "table, th, td {" +
                    "  border: 1px solid black;"
                    + "margin:auto;" +
                    "}"
                    + "h1{"
                    + "text-align:center;"
                    + "}"
                    + "</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Classificação</h1>");


            try {
                List<SQLPlayer> sqlPlayerList = BancoDeDados.getAllPlayers();
                Collections.sort(sqlPlayerList);
                Collections.reverse(sqlPlayerList);
                out.println("<table>");
                out.println("<tr>");
                out.println("<td> Posição</td>");
                out.println("<td> Nome</td>");
                out.println("<td> Pontos</td>");
                out.println("<td> Vitórias</td>");
                out.println("<td> Empates</td>");
                out.println("<td> Derrotas</td>");
                out.println("<td> Damas Feitas</td>");
                out.println("<td> Damas Tomadas</td>");
                out.println("<td> Saldo de damas</td>");
                out.println("</tr>");
                int i=1;

                for(SQLPlayer sqlPlayer: sqlPlayerList){
                    out.println("<tr align=\"center\">");
                    out.println("<td>"+i+"</td>");
                    out.println("<td>"+sqlPlayer.getName()+"</td>");
                    out.println("<td>"+sqlPlayer.getPontos()+"</td>");
                    out.println("<td>"+sqlPlayer.getWins()+"</td>");
                    out.println("<td>"+sqlPlayer.getDraws()+"</td>");
                    out.println("<td>"+sqlPlayer.getLoses()+"</td>");
                    out.println("<td>"+sqlPlayer.getDamasGiven()+"</td>");
                    out.println("<td>"+sqlPlayer.getDamasTaken()+"</td>");
                    out.println("<td>"+sqlPlayer.getSaldo()+"</td>");
                    out.println("</tr>");
                    i++;
                }

            }catch (SQLException e){
                out.println("<h1>Aparentemente houve um erro ao acessar o banco de Dados T>T</h1>");
                e.printStackTrace();
            }



            out.println("</table>");

            out.println("</body>");
            out.println("</html>");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}