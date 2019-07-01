package com.example.demo.jooq;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.codegen.maven.example.Tables;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

@Component
public class TestJooq {
    public Result<Record> getBtIds(Collection<Integer> actorIds) {
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "razraz11")) {
            DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
            Result<Record> fetch = create.select().from(Tables.ACTOR).where(Tables.ACTOR.ACTOR_ID.in(actorIds)).fetch();
            return fetch;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
