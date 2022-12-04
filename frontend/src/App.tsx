import React from "react";
import { Routes, Route, Link } from "react-router-dom";

// sample
import { Counter } from "./features/counter/Counter";

// page
import Home from "./features/home/Home";
import Login from "./features/auth/Login";
import SignUp from "./features/auth/SignUp";

import styles from "./App.module.css";

function App() {
  return (
    <div className={styles.app}>
      "Snow Duck World"
      <div
        style={{
          display: "flex",
          flexDirection: "row",
          justifyContent: "center",
          gap: "8px",
        }}
      >
        <Link to="/">홈</Link>
        <Link to="/login">로그인</Link>
        <Link to="/signup">회원가입</Link>
        <Link to="/couter">state 샘플</Link>
      </div>
      <Routes>
        <Route path="" element={<Home />} />
        <Route path="login" element={<Login />} />
        <Route path="signup" element={<SignUp />} />
        <Route path="couter" element={<Counter />} />
      </Routes>
    </div>
  );
}

export default App;
