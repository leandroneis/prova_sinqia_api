package com.sinqia.api.repository.participante;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.sinqia.api.model.Participante;
import com.sinqia.api.model.Participante_;
import com.sinqia.api.repository.filter.ParticipanteFilter;

public class ParticipanteRepositoryImpl implements ParticipanteRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Participante> filtrar(ParticipanteFilter participanteFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Participante> criteria = builder.createQuery(Participante.class);
        Root<Participante> root = criteria.from(Participante.class);

        Predicate[] predicates = criarRestricoes(participanteFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<Participante> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(participanteFilter));
    }

    private Predicate[] criarRestricoes(ParticipanteFilter participanteFilter, CriteriaBuilder builder,Root<Participante> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(participanteFilter.getCpf()) && participanteFilter.getCpf() != null) {
            predicates.add(builder.like(builder.lower(root.get(Participante_.CPF)),
                    "%" + participanteFilter.getCpf().toLowerCase() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistrosPorPagina);
    }

    private Long total(ParticipanteFilter participanteFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Participante> root = criteria.from(Participante.class);

        Predicate[] predicates = criarRestricoes(participanteFilter, builder, root);
        criteria.where(predicates);

        criteria.select(builder.count(root));
        return manager.createQuery(criteria).getSingleResult();
    }

}

