/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.naminhamaquinafunciona.controller;

import br.com.naminhamaquinafunciona.model.Banco;
import br.com.naminhamaquinafunciona.model.Cartao;
import br.com.naminhamaquinafunciona.model.Conta;
import br.com.naminhamaquinafunciona.model.Despesa;
import br.com.naminhamaquinafunciona.model.Receita;
import br.com.naminhamaquinafunciona.model.Usuario;
import br.com.naminhamaquinafunciona.persistance.BancoDAO;
import br.com.naminhamaquinafunciona.persistance.CartaoDAO;
import br.com.naminhamaquinafunciona.persistance.ContaDAO;
import br.com.naminhamaquinafunciona.persistance.DespesaDAO;
import br.com.naminhamaquinafunciona.persistance.FactoryDespesaDAO;
import br.com.naminhamaquinafunciona.persistance.ReceitaDAO;
import br.com.naminhamaquinafunciona.persistance.UsuarioDAO;
import br.com.naminhamaquinafunciona.validation.SqlData;
import br.com.naminhamaquinafunciona.validation.ValidaBanco;
import br.com.naminhamaquinafunciona.validation.ValidaCartao;
import br.com.naminhamaquinafunciona.validation.ValidaConta;
import br.com.naminhamaquinafunciona.validation.ValidaReceita;
import br.com.naminhamaquinafunciona.validation.ValidaUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;


import java.util.HashMap;

@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    private static final HashMap<String, Integer> GRAVADOR = new HashMap<>();

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("botaoBanco") != null) {

            BancoDAO bdao = new BancoDAO();
            if (request.getParameter("banco_id").contains("^[0-9]*$") == true) {
                request.setAttribute("data5", false);
                RequestDispatcher rd = request.getRequestDispatcher("banco.jsp");
                rd.forward(request, response);
            }

            ValidaBanco valBanco = new ValidaBanco();

            String acao = request.getParameter("botaoBanco");
            switch (acao) {
                case "c":
                    int id = 0;
                    if (!request.getParameter("banco_id").isBlank()) {
                        id = Integer.parseInt(request.getParameter("banco_id"));
                    }

                    String descricao = request.getParameter("descricaobanco");

                    if (!valBanco.bancoPermitido(descricao)) {
                        request.setAttribute("data4", false);
                        RequestDispatcher rd = request.getRequestDispatcher("banco.jsp");
                        rd.forward(request, response);

                    } else if (bdao.retornaBancoPorId(id) == null && bdao.retornaBancoPorDescricao(descricao) == null) {
                        Banco banco = new Banco(id, descricao);
                        banco.setDescricao(descricao);
                        banco.setId(id);

                        bdao.inserirBanco(banco);
                        request.setAttribute("data1", false);
                        RequestDispatcher rd = request.getRequestDispatcher("banco.jsp");
                        rd.forward(request, response);

                    } else {
                        request.setAttribute("data2", false);
                        RequestDispatcher rd = request.getRequestDispatcher("banco.jsp");
                        rd.forward(request, response);

                    }
                    break;
                case "r":
                    request.setAttribute("lista", bdao.listarBancos());
                    RequestDispatcher rd = request.getRequestDispatcher("listaBanco.jsp");
                    rd.forward(request, response);
                    break;
                case "u":
                    id = 0;
                    if (!request.getParameter("banco_id").isBlank()) {
                        id = Integer.parseInt(request.getParameter("banco_id"));
                    }
                    descricao = request.getParameter("descricaobanco");
                    if (!valBanco.bancoPermitido(descricao)) {
                        request.setAttribute("data4", false);
                        rd = request.getRequestDispatcher("banco.jsp");
                        rd.forward(request, response);
                    } else if (bdao.retornaBancoPorId(id) != null) {
                        Banco banco = new Banco(id, descricao);
                        bdao.alterarBanco(banco);
                        rd = request.getRequestDispatcher("banco.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("data3", false);
                        rd = request.getRequestDispatcher("banco.jsp");
                        rd.forward(request, response);

                    }
                    break;
                case "d":
                    id = 0;
                    if (!request.getParameter("banco_id").isBlank()) {
                        id = Integer.parseInt(request.getParameter("banco_id"));
                    }

                    if (bdao.retornaBancoPorId(id) != null) {
                        bdao.removerBanco(id);
                        rd = request.getRequestDispatcher("banco.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("data3", false);
                        rd = request.getRequestDispatcher("banco.jsp");
                        rd.forward(request, response);
                    }
                    break;
                default:

            }

        }

        if (request.getParameter("botaovoltarlogin") != null) {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }

        if (request.getParameter("botaocadastro") != null) {
            UsuarioDAO userDAO = new UsuarioDAO();
            String login = request.getParameter("userlogin");
            String senha = request.getParameter("usersenha");

            ValidaUsuario valUser = new ValidaUsuario();

            if (valUser.validaUsuario(login) == false) {
                request.setAttribute("data3", false);
                RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp");
                rd.forward(request, response);
            }

            if (valUser.validaSenha(senha) == false) {
                request.setAttribute("data1", false);
                RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp");
                rd.forward(request, response);
            }

            if (userDAO.retornaUsuarioPorLogin(login) == null) {

                Usuario user = new Usuario(login, senha);
                userDAO.inserirUsuario(user);

                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("data2", false);
                RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp");
                rd.forward(request, response);
            }
        }

        if (request.getParameter("botaologin") != null) {

            ValidaUsuario novo = new ValidaUsuario();
            
            if (novo.login(request.getParameter("login"), request.getParameter("senha")) == true) {
                GRAVADOR.put("usuario", novo.RetornaIdUser(request.getParameter("login")));
                RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
                rd.forward(request, response);
            } else {

                request.setAttribute("data2", false);
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }

        }

        if (request.getParameter("botaoconta") != null) {
            ContaDAO cDAO = new ContaDAO();

            String acao = request.getParameter("botaoconta");
            ValidaConta valConta = new ValidaConta();
            switch (acao) {
                case "c":
                    int numero = 0;
                    double saldo = 0,
                     limite = 0;
                    if (request.getParameter("numeroconta").isBlank() || request.getParameter("saldoconta").isBlank() || request.getParameter("limiteconta").isBlank()) {
                        request.setAttribute("data1", false);
                        RequestDispatcher rd = request.getRequestDispatcher("conta.jsp");
                        rd.forward(request, response);
                    } else if (valConta.contaPermitida(request.getParameter("numeroconta"))) {
                        numero = Integer.parseInt(request.getParameter("numeroconta"));
                        saldo = Double.parseDouble(request.getParameter("saldoconta"));
                        limite = Double.parseDouble(request.getParameter("limiteconta"));

                    } else {
                        request.setAttribute("data4", false);
                        RequestDispatcher rd = request.getRequestDispatcher("conta.jsp");
                        rd.forward(request, response);
                    }

                    if (cDAO.retornaContaPorNumero(numero) == null) {

                        Conta conta = new Conta(numero, saldo, limite, GRAVADOR.get("usuario"));

                        cDAO.inserirConta(conta);
                        RequestDispatcher rd = request.getRequestDispatcher("conta.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("data2", false);
                        RequestDispatcher rd = request.getRequestDispatcher("conta.jsp");
                        rd.forward(request, response);
                    }
                    break;
                case "r":
                    request.setAttribute("lista", cDAO.listarConta());
                    RequestDispatcher rd = request.getRequestDispatcher("listarConta.jsp");
                    rd.forward(request, response);
                    break;
                case "u":
                    numero = 0;
                    saldo = 0;
                    limite = 0;
                    if (request.getParameter("numeroconta").isBlank() || request.getParameter("saldoconta").isBlank() || request.getParameter("limiteconta").isBlank()) {
                        request.setAttribute("data1", false);
                        rd = request.getRequestDispatcher("conta.jsp");
                        rd.forward(request, response);
                    } else {
                        if (valConta.contaPermitida(request.getParameter("numeroconta"))) {
                            numero = Integer.parseInt(request.getParameter("numeroconta"));
                            saldo = Double.parseDouble(request.getParameter("saldoconta"));
                            limite = Double.parseDouble(request.getParameter("limiteconta"));
                        } else {
                            request.setAttribute("data4", false);
                            rd = request.getRequestDispatcher("conta.jsp");
                            rd.forward(request, response);
                        }
                    }
                    if (cDAO.retornaContaPorNumero(numero) == null) {
                        request.setAttribute("data3", false);
                        rd = request.getRequestDispatcher("conta.jsp");
                        rd.forward(request, response);
                    } else {
                        Conta conta = new Conta(numero, saldo, limite);
                        cDAO.alterarConta(conta);
                        rd = request.getRequestDispatcher("conta.jsp");
                        rd.forward(request, response);
                    }

                    break;

                case "d":
                    numero = 0;
                    if (request.getParameter("numeroconta").isBlank()) {
                        request.setAttribute("data1", false);
                        rd = request.getRequestDispatcher("conta.jsp");
                        rd.forward(request, response);
                    } else {
                        numero = Integer.parseInt(request.getParameter("numeroconta"));
                    }
                    if (cDAO.retornaContaPorNumero(numero) == null) {
                        request.setAttribute("data3", false);
                        rd = request.getRequestDispatcher("conta.jsp");
                        rd.forward(request, response);
                    } else {
                        cDAO.removerConta(numero);
                        rd = request.getRequestDispatcher("conta.jsp");
                        rd.forward(request, response);
                    }
                    break;

                default:

            }

        }

        if (request.getParameter("botaocartao") != null) {
            CartaoDAO cardDAO = new CartaoDAO();

            String acao = request.getParameter("botaocartao");
            ValidaCartao valCartao = new ValidaCartao();
            switch (acao) {
                case "c":
                    // numerocartao   nomecartao   bandeira    limite     agencia   numeroconta
                    int numeroCartao = 0,
                     agencia = 0,
                     numeroConta = 0;
                    double limite = 0;
                    String nomeCartao = null,
                     bandeira = null;
                    if (request.getParameter("numerocartao").isBlank() || request.getParameter("numeroconta").isBlank() || request.getParameter("nomecartao").isBlank() || request.getParameter("agencia").isBlank()) {
                        request.setAttribute("data1", false);
                        RequestDispatcher rd = request.getRequestDispatcher("cartao.jsp");
                        rd.forward(request, response);
                    }
                    if (valCartao.validaNomeCartao(request.getParameter("nomecartao"))) {
                        ContaDAO contaDAO = new ContaDAO();
                        if (contaDAO.retornaContaPorNumero(Integer.parseInt(request.getParameter("numeroconta"))) != null) {
                            if (valCartao.validaAgenciaCartao(agencia)) {
                                numeroCartao = Integer.parseInt(request.getParameter("numerocartao"));
                                if (!request.getParameter("limite").isBlank()) {
                                    limite = Double.parseDouble(request.getParameter("limite"));
                                }
                                nomeCartao = request.getParameter("nomecartao");
                                agencia = Integer.parseInt(request.getParameter("agencia"));
                                numeroConta = Integer.parseInt(request.getParameter("numeroconta"));
                                bandeira = request.getParameter("bandeira");
                            } else {
                                request.setAttribute("data5", false);
                                RequestDispatcher rd = request.getRequestDispatcher("cartao.jsp");
                                rd.forward(request, response);
                            }

                        } else {
                            request.setAttribute("data3", false);
                            RequestDispatcher rd = request.getRequestDispatcher("cartao.jsp");
                            rd.forward(request, response);
                        }

                    } else {
                        request.setAttribute("data2", false);
                        RequestDispatcher rd = request.getRequestDispatcher("cartao.jsp");
                        rd.forward(request, response);
                    }

                    if (cardDAO.retornaCartaoPorNumero(numeroCartao) == null) {

                        Cartao cartao = new Cartao(numeroCartao, nomeCartao, bandeira, limite, agencia, GRAVADOR.get("usuario"), numeroConta);

                        cardDAO.inserirCartao(cartao);
                        RequestDispatcher rd = request.getRequestDispatcher("cartao.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("data4", false);
                        RequestDispatcher rd = request.getRequestDispatcher("cartao.jsp");
                        rd.forward(request, response);
                    }
                    break;
                case "r":
                    request.setAttribute("lista", cardDAO.listarCartao());
                    RequestDispatcher rd = request.getRequestDispatcher("listacartao.jsp");
                    rd.forward(request, response);
                    break;
                case "u":
                    numeroCartao = 0;
                    agencia = 0;
                    numeroConta = 0;
                    limite = 0;
                    nomeCartao = null;
                    bandeira = null;
                    if (request.getParameter("numerocartao").isBlank() || request.getParameter("numeroconta").isBlank() || request.getParameter("nomecartao").isBlank() || request.getParameter("agencia").isBlank()) {
                        request.setAttribute("data1", false);
                        rd = request.getRequestDispatcher("cartao.jsp");
                        rd.forward(request, response);
                    }
                    if (valCartao.validaNomeCartao(request.getParameter("nomecartao"))) {
                        ContaDAO contaDAO = new ContaDAO();
                        if (contaDAO.retornaContaPorNumero(Integer.parseInt(request.getParameter("numeroconta"))) != null) {
                            if (valCartao.validaAgenciaCartao(agencia)) {
                                numeroCartao = Integer.parseInt(request.getParameter("numerocartao"));
                                if (!request.getParameter("limite").isBlank()) {
                                    limite = Double.parseDouble(request.getParameter("limite"));
                                }
                                nomeCartao = request.getParameter("nomecartao");
                                agencia = Integer.parseInt(request.getParameter("agencia"));
                                numeroConta = Integer.parseInt(request.getParameter("numeroconta"));
                                bandeira = request.getParameter("bandeira");
                            } else {
                                request.setAttribute("data5", false);
                                rd = request.getRequestDispatcher("cartao.jsp");
                                rd.forward(request, response);
                            }

                        } else {
                            request.setAttribute("data3", false);
                            rd = request.getRequestDispatcher("cartao.jsp");
                            rd.forward(request, response);
                        }

                    } else {
                        request.setAttribute("data2", false);
                        rd = request.getRequestDispatcher("cartao.jsp");
                        rd.forward(request, response);
                    }

                    if (cardDAO.retornaCartaoPorNumero(numeroCartao) != null) {

                        Cartao cartao = new Cartao(numeroCartao, nomeCartao, bandeira, limite, agencia, GRAVADOR.get("usuario"), numeroConta);

                        cardDAO.alterarCartao(cartao);
                        rd = request.getRequestDispatcher("cartao.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("data6", false);
                        rd = request.getRequestDispatcher("cartao.jsp");
                        rd.forward(request, response);
                    }

                    break;

                case "d":
                    numeroCartao = 0;
                    if (request.getParameter("numerocartao").isBlank()) {
                        request.setAttribute("data1", false);
                        rd = request.getRequestDispatcher("cartao.jsp");
                        rd.forward(request, response);
                    } else {
                        numeroCartao = Integer.parseInt(request.getParameter("numerocartao"));
                    }
                    if (cardDAO.retornaCartaoPorNumero(numeroCartao) == null) {
                        request.setAttribute("data6", false);
                        rd = request.getRequestDispatcher("cartao.jsp");
                        rd.forward(request, response);
                    } else {
                        cardDAO.removerCartao(numeroCartao);
                        rd = request.getRequestDispatcher("cartao.jsp");
                        rd.forward(request, response);
                    }
                    break;

                default:

            }

        }

        if (request.getParameter("botaoReceita") != null) {
            ReceitaDAO rDAO = new ReceitaDAO();
            String acao = request.getParameter("botaoReceita");
            //descricao, valor, data, cartaoid
            switch (acao) {
                case "c":

                    if (request.getParameter("valor").isBlank() || request.getParameter("data").isBlank() || request.getParameter("idreceita").isBlank()) {
                        request.setAttribute("data1", false);
                        RequestDispatcher rd = request.getRequestDispatcher("receita.jsp");
                        rd.forward(request, response);
                    } else {
                        if (Integer.parseInt(request.getParameter("valor")) == 0) {
                            request.setAttribute("data2", false);
                            RequestDispatcher rd = request.getRequestDispatcher("receita.jsp");
                            rd.forward(request, response);
                        }
                        if (rDAO.retornaReceitaPorId(Integer.parseInt(request.getParameter("idreceita"))) == null) {
                            Receita receita = new Receita();
                            ValidaReceita valReceita = new ValidaReceita();
                            if (!request.getParameter("numconta").isBlank()) {
                                ContaDAO cDAO = new ContaDAO();
                                if (cDAO.retornaContaPorNumero(Integer.parseInt(request.getParameter("numconta"))) != null) {
                                    receita.setNumConta(Integer.parseInt(request.getParameter("numconta")));
                                } else {
                                    request.setAttribute("data4", false);
                                    RequestDispatcher rd = request.getRequestDispatcher("receita.jsp");
                                    rd.forward(request, response);
                                }
                            }

                            receita.setDescricao(request.getParameter("descricao"));
                            receita.setValor(Double.parseDouble(request.getParameter("valor")));
                            receita.setData(valReceita.PadronizaData(request.getParameter("data")));
                            receita.setId(Integer.parseInt(request.getParameter("idreceita")));
                            rDAO.inserirReceita(receita);
                            RequestDispatcher rd = request.getRequestDispatcher("receita.jsp");
                            rd.forward(request, response);
                        } else {
                            request.setAttribute("data6", false);
                            RequestDispatcher rd = request.getRequestDispatcher("receita.jsp");
                            rd.forward(request, response);
                        }
                    }

                    break;

                case "r":

                    request.setAttribute("lista", rDAO.listarReceita());
                    RequestDispatcher rd = request.getRequestDispatcher("listarreceita.jsp");
                    rd.forward(request, response);
                    break;
                case "u":
                    if (Integer.parseInt(request.getParameter("valor")) == 0) {
                        request.setAttribute("data2", false);
                        rd = request.getRequestDispatcher("receita.jsp");
                        rd.forward(request, response);
                    }
                    if (request.getParameter("valor").isBlank() || request.getParameter("data").isBlank() || Integer.parseInt(request.getParameter("idreceita")) == 0) {
                        request.setAttribute("data1", false);
                        rd = request.getRequestDispatcher("receita.jsp");
                        rd.forward(request, response);
                    } else {
                        if (rDAO.retornaReceitaPorId(Integer.parseInt(request.getParameter("idreceita"))) == null) {
                            request.setAttribute("data5", false);
                            rd = request.getRequestDispatcher("receita.jsp");
                            rd.forward(request, response);

                        }
                        ValidaReceita valReceita = new ValidaReceita();
                        Receita receita = new Receita();

                        if (!request.getParameter("numconta").isBlank()) {
                            receita.setNumConta(Integer.parseInt(request.getParameter("numconta")));
                        }

                        receita.setDescricao(request.getParameter("descricao"));
                        receita.setValor(Double.parseDouble(request.getParameter("valor")));
                        receita.setData(valReceita.PadronizaData(request.getParameter("data")));
                        receita.setId(Integer.parseInt(request.getParameter("idreceita")));
                        rDAO.alterarReceita(receita);
                        rd = request.getRequestDispatcher("receita.jsp");
                        rd.forward(request, response);
                    }
                    break;
                case "d":
                    if (request.getParameter("idreceita").isBlank()) {
                        request.setAttribute("data3", false);
                        rd = request.getRequestDispatcher("receita.jsp");
                        rd.forward(request, response);
                    } else {
                        if (rDAO.retornaReceitaPorId(Integer.parseInt(request.getParameter("idreceita"))) == null) {
                            request.setAttribute("data5", false);
                            rd = request.getRequestDispatcher("receita.jsp");
                            rd.forward(request, response);
                        }
                        rDAO.removerReceita(Integer.parseInt(request.getParameter("idreceita")));
                        rd = request.getRequestDispatcher("receita.jsp");
                        rd.forward(request, response);
                    }
                    break;
                default:
            }
        }

        if (request.getParameter("botaoDespesa") != null) {
            DespesaDAO despDAO = new DespesaDAO();
            FactoryDespesaDAO factory = new FactoryDespesaDAO();
            String acao = request.getParameter("botaoDespesa");

            switch (acao) {
                case "c":
                    if (request.getParameter("valor").isBlank() || request.getParameter("data").isBlank() || request.getParameter("id").isBlank()) {
                        request.setAttribute("data3", false);
                        RequestDispatcher rd = request.getRequestDispatcher("despesa.jsp");
                        rd.forward(request, response);
                    }
                    if (Integer.parseInt(request.getParameter("valor")) == 0) {
                        request.setAttribute("data1", false);
                        RequestDispatcher rd = request.getRequestDispatcher("despesa.jsp");
                        rd.forward(request, response);
                    }
                    if (Integer.parseInt(request.getParameter("id")) == 0) {
                        request.setAttribute("data2", false);
                        RequestDispatcher rd = request.getRequestDispatcher("despesa.jsp");
                        rd.forward(request, response);
                    }

                    if (despDAO.retornaDespesaPorId(Integer.parseInt(request.getParameter("id"))) == null) {
                        Despesa despesa = new Despesa();

                        if (!request.getParameter("numconta").isBlank()) {

                            ContaDAO cDAO = new ContaDAO();
                            if (cDAO.retornaContaPorNumero(Integer.parseInt(request.getParameter("numconta"))) != null) {
                                despesa.setNumConta(Integer.parseInt(request.getParameter("numconta")));
                            } else {
                                request.setAttribute("data4", false);
                                RequestDispatcher rd = request.getRequestDispatcher("despesa.jsp");
                                rd.forward(request, response);
                            }
                        }
                        if (!request.getParameter("numcartao").isBlank()) {
                            CartaoDAO cardDAO = new CartaoDAO();
                            if (cardDAO.retornaCartaoPorNumero(Integer.parseInt(request.getParameter("numcartao"))) != null) {
                                despesa.setNumCartao(Integer.parseInt(request.getParameter("numcartao")));

                            } else {
                                request.setAttribute("data6", false);
                                RequestDispatcher rd = request.getRequestDispatcher("despesa.jsp");
                                rd.forward(request, response);
                            }
                        }
                        
                        SqlData nova = new SqlData();
                        despesa.setData(nova.StringToSql(request.getParameter("data")));
                        despesa.setDescricao(request.getParameter("descricao"));
                        despesa.setValor(Double.parseDouble(request.getParameter("valor")));
                        despesa.setId(Integer.parseInt(request.getParameter("id")));

                        factory.FactoryExecutaMetodo("inserir", despesa);
//                        DespesaDAO despeDAO= new DespesaDAO();
//                        despeDAO.inserirDespesa(despesa);

                        RequestDispatcher rd = request.getRequestDispatcher("despesa.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("data5", false);
                        RequestDispatcher rd = request.getRequestDispatcher("despesa.jsp");
                        rd.forward(request, response);
                    }

                    break;
                case "r":
                    request.setAttribute("lista", despDAO.listarDespesa());
                    RequestDispatcher rd = request.getRequestDispatcher("listardespesa.jsp");
                    rd.forward(request, response);
                    break;
                case "u":

                    if (request.getParameter("valor").isBlank() || request.getParameter("data").isBlank() || request.getParameter("id").isBlank()) {
                        request.setAttribute("data3", false);
                        rd = request.getRequestDispatcher("despesa.jsp");
                        rd.forward(request, response);
                    }
                    if (Integer.parseInt(request.getParameter("valor")) == 0) {
                        request.setAttribute("data1", false);
                        rd = request.getRequestDispatcher("despesa.jsp");
                        rd.forward(request, response);
                    }
                    if (Integer.parseInt(request.getParameter("id")) == 0) {
                        request.setAttribute("data2", false);
                        rd = request.getRequestDispatcher("despesa.jsp");
                        rd.forward(request, response);
                    }
                    if (despDAO.retornaDespesaPorId(Integer.parseInt(request.getParameter("id"))) != null) {
                        Despesa despesa = new Despesa();

                        if (!request.getParameter("numconta").isBlank()) {

                            ContaDAO cDAO = new ContaDAO();
                            if (cDAO.retornaContaPorNumero(Integer.parseInt(request.getParameter("numconta"))) != null) {
                                despesa.setNumConta(Integer.parseInt(request.getParameter("numconta")));
                            } else {
                                request.setAttribute("data4", false);
                                rd = request.getRequestDispatcher("despesa.jsp");
                                rd.forward(request, response);
                            }
                        }
                        if (!request.getParameter("numcartao").isBlank()) {
                            CartaoDAO cardDAO = new CartaoDAO();
                            if (cardDAO.retornaCartaoPorNumero(Integer.parseInt(request.getParameter("numcartao"))) != null) {
                                despesa.setNumCartao(Integer.parseInt(request.getParameter("numcartao")));

                            } else {
                                request.setAttribute("data6", false);
                                rd = request.getRequestDispatcher("despesa.jsp");
                                rd.forward(request, response);
                            }
                        }

                        despesa.setId(Integer.parseInt(request.getParameter("id")));
                        despesa.setDescricao(request.getParameter("descricao"));
                        despesa.setValor(Double.parseDouble(request.getParameter("valor")));
                        SqlData nova = new SqlData();
                        despesa.setData(nova.StringToSql(request.getParameter("data")));

                        factory.FactoryExecutaMetodo("alterar", despesa);

                        rd = request.getRequestDispatcher("despesa.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("data5", false);
                        rd = request.getRequestDispatcher("despesa.jsp");
                        rd.forward(request, response);
                    }

                    break;
                case "d":
                    if (request.getParameter("id").isBlank()) {
                        request.setAttribute("data6", false);
                        rd = request.getRequestDispatcher("despesa.jsp");
                        rd.forward(request, response);
                    } else {
                        if (despDAO.retornaDespesaPorId(Integer.parseInt(request.getParameter("id"))) == null) {
                            request.setAttribute("data5", false);
                            rd = request.getRequestDispatcher("despesa.jsp");
                            rd.forward(request, response);
                        }
                        Despesa despesa = new Despesa();
                        despesa.setId(Integer.parseInt(request.getParameter("id")));
                        factory.FactoryExecutaMetodo("remover", despesa);
                        rd = request.getRequestDispatcher("despesa.jsp");
                        rd.forward(request, response);
                    }

                    break;
                default:
            }

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
