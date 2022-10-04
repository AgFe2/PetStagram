// import React, { useState } from "react";
// import axios from "axios";
// import styles from "../../../styles/ContentModal.module.css";



// const CommentForm = () => {
//     const [commentValue, setCommentValue] = useState("");

//     const onChangeComment = (e) => {
//         console.log(typeof e.target.value);
//         setCommentValue(e.target.value);
//     };
//     const feedId = 1
//     const addComment = async (e) => {
//         e.preventDefault();
//         await axios.post(
//             `http://localhost:8080/feed/save-comment?feedId=${feedId}`,
//             JSON.stringify({
//                 context: commentValue,
//             }),
//             {
//                 headers: {
//                     "Content-Type": "application/json",
//                     "Authorization": "Bearer" + localStorage.getItem("JWT"),
//                 },
//             }
//         )
//             .then((res) => {
//                 setCommentValue("");
//                 console.log(res);
//                 res.json();
//             })
//             .catch((e) => console.log(e))
//         };
        

//     return (
//         <>
//             <form className={styles.inputForm} onSubmit={addComment}>
//                 <input
//                     type="text"
//                     placeholder="댓글 달기..."
//                     className={styles.inputComment}
//                     value={commentValue}
//                     onChange={onChangeComment}
//                 />
//                 {commentValue.length > 0 ? (
//                     <button
//                         type="submit"
//                         className={`${styles.inputButton} ${styles.btnActive}`}
//                     >
//                         게시
//                     </button>
//                 ) : (
//                     <button type="button" className={styles.inputButton}>
//                         게시
//                     </button>
//                 )}
//             </form>
//         </>
//     );
// };

// export default CommentForm;