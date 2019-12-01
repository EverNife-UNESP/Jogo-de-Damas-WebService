import br.com.finalcraft.unesp.java.jogodamas.webservice.sql.BancoDeDados;
import br.com.finalcraft.unesp.java.jogodamas.webservice.sql.data.SQLBattleLog;
import br.com.finalcraft.unesp.java.jogodamas.webservice.sql.data.SQLPlayer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "BattlelogsServlet", urlPatterns = {"battlelogs"}, loadOnStartup = 1)
public class BattlelogsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>BattleLogs</title>");
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
            out.println("<h1>BattleLogs</h1>");


            try {
                List<SQLBattleLog> sqlBattleLogs = BancoDeDados.getAllBattleLogs();
                Collections.sort(sqlBattleLogs);
                out.println("<table>");
                out.println("<tr>");
                out.println("<td> Data </td>");
                out.println("<td> Jogador 1 </td>");
                out.println("<td> Jogador 2 </td>");
                out.println("<td> Damas Jogador 1 </td>");
                out.println("<td> Damas Jogador 2 </td>");
                out.println("<td> Vencedor </td>");
                out.println("</tr>");
                int i=1;

                for(SQLBattleLog sqlBattleLog: sqlBattleLogs){
                    out.println("<tr align=\"center\">");
                    out.println("<td>"+sqlBattleLog.getDate().getFormatedFullDate()+"</td>");
                    out.println("<td>"+sqlBattleLog.getPlayerOne()+"</td>");
                    out.println("<td>"+sqlBattleLog.getPlayerTwo()+"</td>");
                    out.println("<td>"+sqlBattleLog.getPlayerOneDamas()+"</td>");
                    out.println("<td>"+sqlBattleLog.getPlayerTwoDamas()+"</td>");
                    out.println("<td>"+sqlBattleLog.getWinner()+"</td>");
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