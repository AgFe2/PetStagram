import React, { useEffect, useState } from "react";
import axios from "axios";

// CSS
import styles from "../../styles/Contents.module.css";
import { FaHeart, FaRegHeart } from "react-icons/fa";

function Liked(props) {
  // const [likedBtn, setLikedBtn] = useState(false);

  // const toggleLiked = async (e) => {
  //   const res = await axios.post("feed/like", {
  //     params: { userID: "", feedId: "" },
  //   });
  //   setLikedBtn(!likedBtn);
  //   return res;
  // };

  // useEffect(() => {
  //   const fetchData = async () => {
  //     const res = await axios.get("feed/like", {
  //       params: { userID: "", feedId: "" },
  //     });
  //     if (res.data.type === "liked") setLikedBtn(true);
  //   };
  //   fetchData();
  // }, []);

  return (
    <div className={styles.infoLiked}>
      {/* <button onClick={toggleLiked} className={styles.likedBtn}>
        {likedBtn ? <FaHeart /> : <FaRegHeart />}
      </button>
      <p style={{ fontWeight: "bold" }}>{props.liked} liked</p> */}
    </div>
  );
}

export default Liked;
