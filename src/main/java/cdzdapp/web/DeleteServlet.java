package cdzdapp.web;

import cdzdapp.domain.User;
import cdzdapp.repository.DbFriendRepository;
import cdzdapp.repository.DbUserRepository;
import cdzdapp.repository.FriendRepository;
import cdzdapp.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    private final UserRepository userRepository = DbUserRepository.INSTANCE;
    private final FriendRepository friendRepository = DbFriendRepository.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = getUser(request);
        if (user == null) {
            request.getRequestDispatcher("/logout").forward(request, response);
            return;
        }

        request.setCharacterEncoding("UTF-8");
        Integer id = Integer.valueOf(request.getParameter("id"));
        friendRepository.deleteFriend(user.getId(), id);

        response.sendRedirect("/friends");
    }

    private User getUser(HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        }

        String userId = (String) session.getAttribute("user");
        if (userId == null) {
            return null;
        }

        return userRepository.getUserById(Integer.valueOf(userId));
    }
}